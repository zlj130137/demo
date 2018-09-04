package com.survey.dao;

import com.survey.entity.User;

public interface UserMapper {
//    int deleteByPrimaryKey(Integer id);

//    int insert(User record);

    int insertSelective(User record);

    User selectByUser(User record);
    
    int selectUserIdByUserName(String username);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
}