package com.undefined24.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.undefined24.ssm.dao.UserMapper;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.History;
import com.undefined24.ssm.vo.Receiver;
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
	
	//注册身份证号查重
	@Transactional
	public User checkUserNumber(String usernumber){
		return userMapper.checkUserNumber(usernumber);
	}
	
	//登录
	@Transactional
	public User Login(User user){
		return userMapper.Login(user);
	}
	
	//修改个人资料
	@Transactional
	public int ChangeProfile(User user){
		return userMapper.ChangeProfile(user);
	}
	
	//下单时添加物品
	@Transactional
	public int addGoods(Goods goods){
		return userMapper.addGoods(goods);
	}
	
	//下单时添加订单
	@Transactional
	public int addBill(Bill bill){
		return userMapper.addBill(bill);
	}
	
	//下单时添加收件人
	@Transactional
	public int addReceiver(Receiver rec){
		return userMapper.addReceiver(rec);
	}
	
	//查询物品
	@Transactional
	public List<Goods> selectGoods(int trackingID){
		return userMapper.selectGoods(trackingID);
	}
	
	//列出当前用户寄件单
	@Transactional
	public List<Bill> sendGoods(User user){
		return userMapper.sendGoods(user);
	}
	
	//列出当前用户收件单
	@Transactional
	public List<Bill> acceptGoods(User user){
		return userMapper.acceptGoods(user);
	}
}
