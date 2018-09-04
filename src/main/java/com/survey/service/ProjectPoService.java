package com.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.SurveydataMapper;
import com.survey.dao.SurveymapMapper;
import com.survey.entity.Surveydata;
import com.survey.entity.Surveymap;
import com.survey.pojo.ProjectPo;

@Service("projectPoService")
public class ProjectPoService {

	@Autowired
	private SurveydataMapper sMapper; 
	@Autowired
	private SurveymapMapper sMapper2;
	
	public List<ProjectPo> selectProjectList(){
		List<Surveydata> list = sMapper.selectSurveydataList();
		List<ProjectPo> polist = new ArrayList<ProjectPo>();
		for(Surveydata surveydata : list) {
			ProjectPo po = new ProjectPo();
			po.setId(surveydata.getId());
			po.setBtype(surveydata.getBtype());
			po.setContent(surveydata.getContent());
			String str = surveydata.getBcheck();
			String strarr[] = str.split(",");
			List<Surveymap> myList = new ArrayList<Surveymap>();
			for(int i=0;i<strarr.length;i++) {
				Surveymap my = sMapper2.selectByPrimaryKey(strarr[i]);
				myList.add(my);
			}
			po.setBcheck(myList);
			polist.add(po);
		}
		
		return polist;
	}
}
