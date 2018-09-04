package com.survey.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.survey.dao.SurveydataMapper;
import com.survey.dao.SurveymapMapper;
import com.survey.dao.UserMapper;
import com.survey.entity.Surveydata;
import com.survey.entity.Surveymap;
import com.survey.entity.User;
import com.survey.pojo.ProjectPo;
import com.survey.service.ProjectPoService;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:application/spring.xml"}) //加载配置文件 
public class MyTest {
	@Autowired
	private UserMapper uMapper;
	@Autowired
	private SurveydataMapper surveydata;
	@Autowired
	private SurveymapMapper sMapper;
	@Autowired
	private ProjectPoService poService;

	@Test
	public void test2() {
//		User user = new User();
//		User user2 = new User();
//		user.setUsername("admin");
//		user.setPassword("admin");
//		user2 = uMapper.selectByUser(user);
		int id = uMapper.selectUserIdByUserName("zhang");
//		boolean flag = false;
//		if (user2 != null) {
//			flag = true;
//		}
		System.out.println("teacher="+id);
	}
	
	@Test
	public void test5() {
		Surveymap ss = new Surveymap();
		ss = sMapper.selectByPrimaryKey("yes");
//		ss = sMapper.selectByPrimaryId(1);
		System.out.println("teacher="+ss);
	}
	
	@Test
	public void test6() {
		List<ProjectPo> list = poService.selectProjectList();
		System.out.println("teacher="+list);
	}
	
	@Test
	public void test4() {
		List<Surveydata> list = surveydata.selectSurveydataList();
		System.out.println("teacher="+list);
	}
	
//	@Test
//	public void test3() {
//		User user = new User();
//		user.setUsername("ss");
//		user.setPassword("ss");
//		Integer result = uMapper.insert(user);
//		System.out.println("teacher="+result+"user= " +user);
//	}
}
