package com.survey.dao;

import java.util.List;

import com.survey.entity.Surveydata;

public interface SurveydataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Surveydata record);

    int insertSelective(Surveydata record);

    Surveydata selectByPrimaryKey(Integer id);
    
    List<Surveydata> selectSurveydataList();

    int updateByPrimaryKeySelective(Surveydata record);

    int updateByPrimaryKey(Surveydata record);
}