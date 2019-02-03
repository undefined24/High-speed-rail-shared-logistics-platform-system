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
	
	//检查用户名是否已存在
	@Transactional
	public User CheckUser(User user){
		return userMapper.CheckUser(user);
	}
	
	//登录
	@Transactional
	public User Login(User user){
		return userMapper.Login(user);
	}
	
	//修改密码
	@Transactional
	public int ChangePwd(User user){
		return userMapper.ChangePwd(user);
	}
	
	//修改个人资料
	@Transactional
	public int ChangeProfile(User user){
		return userMapper.ChangeProfile(user);
	}
}
