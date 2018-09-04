package com.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.SurveydataMapper;
import com.survey.entity.Surveydata;

@Service("surveydataService")
public class SurveydataService {

	@Autowired
	private SurveydataMapper sMapper;
	
	public void addSurveydata(Surveydata surveydata) {
		sMapper.insertSelective(surveydata);
	}
	
	public void delSurveydata(Integer id) {
		sMapper.deleteByPrimaryKey(id);
	}
	
	public void updateSurveydata(Surveydata surveydata) {
		sMapper.updateByPrimaryKeySelective(surveydata);
	}
	
	public List<Surveydata> getall(){
		List<Surveydata> list = sMapper.selectSurveydataList();
		return list;
	}
}
