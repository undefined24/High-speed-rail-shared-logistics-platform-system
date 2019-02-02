package com.undefined24.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.undefined24.ssm.dao.UserMapper;
import com.undefined24.ssm.vo.User;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	//注册
	@Transactional
	public int Register(User user){
		return userMapper.Register(user);
	}
}
