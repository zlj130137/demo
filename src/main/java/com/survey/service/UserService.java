package com.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.UserMapper;
import com.survey.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public int register(User record) {
		Integer result = 0;
		result = userMapper.insertSelective(record);
		return result;
	}
	
	public int selectUserIdByUserName(String username) {
		Integer result = userMapper.selectUserIdByUserName(username);
		return result;
	}
	
	public boolean login(User record) {
		User user2 = userMapper.selectByUser(record);
		boolean flag = false;
		if (user2 != null) {
			flag = true;
		}
		return flag;
	}

}
