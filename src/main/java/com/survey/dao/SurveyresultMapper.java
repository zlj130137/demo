package com.survey.dao;

import java.util.List;

import com.survey.entity.Surveyresult;

public interface SurveyresultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Surveyresult record);

    int insertSelective(Surveyresult record);

    Surveyresult selectByPrimaryKey(Integer id);
    
    List<Surveyresult> selectSurveyresultList();

    int updateByPrimaryKeySelective(Surveyresult record);

    int updateByPrimaryKey(Surveyresult record);
}