package com.survey.dao;

import com.survey.entity.Surveymap;

public interface SurveymapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Surveymap record);

    int insertSelective(Surveymap record);

    Surveymap selectByPrimaryId(Integer id);
    
    Surveymap selectByPrimaryKey(String bkey);

    int updateByPrimaryKeySelective(Surveymap record);

    int updateByPrimaryKey(Surveymap record);
}