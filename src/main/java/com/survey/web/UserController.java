package com.survey.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.entity.User;
import com.survey.pojo.BasePo;
import com.survey.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public BasePo login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int id = userService.selectUserIdByUserName(username);
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		boolean flag = userService.login(user);
		BasePo po = new BasePo();
		response.setCharacterEncoding("UTF-8");
		if (flag) {
			po.setCode(1);
			po.setMessege("登录成功");
			po.setData(user);	
		}else {
			po.setCode(0);
			po.setMessege("用户名或密码错误");
		}			
		System.out.println("i am servlet flag = " +flag);		
		return po;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		boolean flag = false;
		if(password.equals(repassword)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			int result = userService.register(user);
			if(result==1) {
				flag = true;
			}else {
				flag = false;
			}		
		}
		else {
			flag = false;
		}
		System.out.println("i am servlet flag = " +flag);		
		return flag;
	}
	
}
