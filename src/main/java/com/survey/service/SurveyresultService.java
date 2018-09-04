package com.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.SurveyresultMapper;
import com.survey.entity.Surveyresult;

@Service("surveyresultService")
public class SurveyresultService {

	@Autowired
	private SurveyresultMapper sMapper;
	
	public void addSurveyresult(Surveyresult surveyresult) {
		sMapper.insertSelective(surveyresult);
	}
	
	public void insertChooseList(List<Surveyresult> list) {
		for(Surveyresult surveyresult:list) {
			sMapper.insertSelective(surveyresult);
		}
	}
	
	public void delSurveyresult(Integer id) {
		sMapper.deleteByPrimaryKey(id);
	}
	
	public void updateSurveyresult(Surveyresult surveyresult) {
		sMapper.updateByPrimaryKeySelective(surveyresult);
	}
	
	public List<Surveyresult> getall(){
		List<Surveyresult> list = sMapper.selectSurveyresultList();
		return list;
	}
}
