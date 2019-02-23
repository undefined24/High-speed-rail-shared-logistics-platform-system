package com.undefined24.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.undefined24.ssm.dao.AdminMapper;
import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.User;
import com.undefined24.ssm.vo.Worker;

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
	
	//增加员工
	@Transactional
	public int addWorker(Worker worker){
		return adminMapper.addWorker(worker);
	}
	
	//员工查重
	@Transactional
	public Worker checkWorker(Worker worker){
		return adminMapper.checkWorker(worker);
	}
	
	//显示员工
	@Transactional
	public List<Worker> showWorker(){
		return adminMapper.showWorker();
	}
	
	//修改员工
	@Transactional
	public int editWorker(Worker worker){
		return adminMapper.editWorker(worker);
	}
	
	//删除员工
	@Transactional
	public int deleteWorker(Worker worker){
		return adminMapper.deleteWorker(worker);
	}
	
	//搜索员工
	@Transactional
	public List<Worker> searchWorker(String search){
		return adminMapper.searchWorker(search);
	}
	
	//显示用户
	@Transactional
	public List<User> showUser(){
		return adminMapper.showUser();
	}
	
	//搜索用户
	@Transactional
	public List<User> searchUser(String userSearch){
		return adminMapper.searchUser(userSearch);
	}
	
	//删除用户
	@Transactional
	public int deleteUser(User user){
		return adminMapper.deleteUser(user);
	}
	
	//用户查重
	@Transactional
	public User checkUser(User user){
		return adminMapper.checkUser(user);
	}
	
	//修改用户
	@Transactional
	public int editUser(User user){
		return adminMapper.editUser(user);
	}
	
	//根据商品id搜查商品
	@Transactional
	public Bill selectBill(int id){
		return adminMapper.selectBill(id);
	}
	
	//寄件管理陈列
	@Transactional
	public List<Goods> goodsManage(){
		return adminMapper.goodsManage();
	}
}
