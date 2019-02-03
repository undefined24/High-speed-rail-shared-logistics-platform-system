package com.undefined24.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.undefined24.ssm.dao.AdminMapper;
import com.undefined24.ssm.vo.Administrator;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	
	//登录
	@Transactional
	public Administrator adminLogin(Administrator admin){
		return adminMapper.adminLogin(admin);
	}
	
	//修改密码
	@Transactional
	public int adminChangePwd(Administrator admin){
		return adminMapper.adminChangePwd(admin);
	}
}
