package com.survey.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.pojo.ProjectPo;
import com.survey.service.ProjectPoService;

@Controller
@RequestMapping("/projectPo")
public class ProjectPoController {

	@Autowired
	private ProjectPoService poservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectPo> list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProjectPo> list = poservice.selectProjectList();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		return list;
	}

}
