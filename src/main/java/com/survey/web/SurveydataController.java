package com.survey.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.survey.entity.Surveydata;
import com.survey.service.SurveydataService;

@Controller
@RequestMapping("/surveydata")
public class SurveydataController {

	@Autowired
	private SurveydataService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String content =request.getParameter("content");
		String str[] = request.getParameterValues("bcheck");
		String bcheck=" ";
		for(int i=0;i<str.length;i++){
			if(i ==0){
	
				bcheck = str[i];
	
			}else {
	
				bcheck += "," + str[i]; 
	
			}
		}
		String btype = request.getParameter("btype");
		Surveydata surveydata = new Surveydata();
		surveydata.setContent(content);
		surveydata.setBcheck(bcheck);
		surveydata.setBtype(btype);
		service.addSurveydata(surveydata);
		response.setCharacterEncoding("UTF-8");
		return "add";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		List<Surveydata> list = service.getall();
		request.setAttribute("list", list);
		return "view";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		service.delSurveydata(Integer.parseInt(id));
		return "view";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String content =request.getParameter("content");
		String str[] = request.getParameterValues("bcheck");
		String bcheck=" ";
		for(int i=0;i<str.length;i++){
			if(i ==0){
	
				bcheck = str[i];
	
			}else {
	
				bcheck += "," + str[i]; 
	
			}
		}
		String btype = request.getParameter("btype");
		Surveydata surveydata = new Surveydata();
		surveydata.setContent(content);
		surveydata.setBcheck(bcheck);
		surveydata.setBtype(btype);
		service.updateSurveydata(surveydata);
		return "view";
	}
	
}
