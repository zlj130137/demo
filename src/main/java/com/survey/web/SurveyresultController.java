package com.survey.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.entity.Surveyresult;
import com.survey.service.SurveyresultService;

@Controller
@RequestMapping("/surveyresult")
public class SurveyresultController {

	@Autowired
	private SurveyresultService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String json = request.getParameter("data");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
	    try {
			List<Surveyresult> list = mapper.readValue(json,new TypeReference<List<Surveyresult>>() { });
			service.insertChooseList(list);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
//		request.setCharacterEncoding("UTF-8");
//		String userid =request.getParameter("userid");
//		String dataid = request.getParameter("dataid");		
//		String checked = request.getParameter("checked");
//		Surveyresult surveyresult = new Surveyresult();
//		surveyresult.setDataid(Integer.parseInt(dataid));
//		surveyresult.setUserid(Integer.parseInt(userid));
//		surveyresult.setChecked(checked);
//		service.addSurveyresult(surveyresult);
//		response.setCharacterEncoding("UTF-8");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		List<Surveyresult> list = service.getall();
		request.setAttribute("list", list);
		return "";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		service.delSurveyresult(Integer.parseInt(id));
		return "";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String userid =request.getParameter("userid");
		String dataid = request.getParameter("dataid");		
		String checked = request.getParameter("checked");
		Surveyresult surveyresult = new Surveyresult();
		surveyresult.setDataid(Integer.parseInt(dataid));
		surveyresult.setUserid(Integer.parseInt(userid));
		surveyresult.setChecked(checked);
		service.updateSurveyresult(surveyresult);
		return "";
	}
}
