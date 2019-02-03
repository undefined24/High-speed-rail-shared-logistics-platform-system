package com.undefined24.ssm.dao;

import com.undefined24.ssm.vo.User;

public interface UserMapper {
	public int Register(User user);
	public User CheckUser(User user);
	public User Login(User user);
	public int ChangePwd(User user);
	public int ChangeProfile(User user);
}
