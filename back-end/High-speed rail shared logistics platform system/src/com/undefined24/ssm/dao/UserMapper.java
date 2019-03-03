package com.undefined24.ssm.dao;

import java.util.List;

import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.History;
import com.undefined24.ssm.vo.Receiver;
import com.undefined24.ssm.vo.Train;
import com.undefined24.ssm.vo.User;

public interface UserMapper {
	public int Register(User user);
	public User CheckUser(User user);
	public User Login(User user);
	public int ChangeProfile(User user);
	
	public User checkUserNumber(String usernumber);
	public int addGoods(Goods goods);
	public int addBill(Bill bill);
	public int addReceiver(Receiver rec);
	public List<Goods> selectGoods(int trackingID);
	public List<Bill> sendGoods(User user);
	public List<Bill> acceptGoods(User user);
	public List<Bill> receiveGoods(Train train);
	public List<Bill> searchBill(String search_str);
}
