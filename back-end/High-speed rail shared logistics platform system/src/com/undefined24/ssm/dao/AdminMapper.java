package com.undefined24.ssm.dao;

import java.util.List;

import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.User;
import com.undefined24.ssm.vo.Worker;



public interface AdminMapper {
	public Administrator adminLogin(Administrator admin);
	public int adminChangePwd(Administrator admin);
	public int addWorker(Worker worker);
	public Worker checkWorker(Worker worker);
	public List<Worker> showWorker();
	public int editWorker(Worker worker);
	public int deleteWorker(Worker worker);
	public List<Worker> searchWorker(String search);
	
	public List<User> showUser();
	public List<User> searchUser(String search);
	public int deleteUser(User user);
	public User checkUser(User user);
	public int editUser(User user);
	
	public Bill selectBill(int trackingID);
	public List<Goods> goodsManage(int trackingid);
}