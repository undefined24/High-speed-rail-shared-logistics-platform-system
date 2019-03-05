package com.undefined24.ssm.dao;

import java.util.List;

import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.Receiver;
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
	public Worker showEditWorker(int workerID);
	
	public List<User> showUser();
	public List<User> searchUser(String search);
	public int deleteUser(User user);
	public User checkUser(User user);
	public int editUser(User user);
	public User showEditUser(int userID);
	
	public Bill selectBill(int trackingID);
	public List<Goods> goodsManage();
	public List<Goods> searchGoods(String search);
	public Goods checkGoods(String name);
	public int deleteGoods(Goods goods);
	public int deleteBill(Bill bill);
	public int deleteReceiver(Receiver receiver);
	public Goods showEditGoods(int trackingID);
	public int editGoods(Goods goods);
	public int editBill(Bill bill);
}