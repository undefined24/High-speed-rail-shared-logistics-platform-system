package com.undefined24.ssm.dao;

import com.undefined24.ssm.vo.Administrator;

public interface AdminMapper {
	public Administrator adminLogin(Administrator admin);
	public int adminChangePwd(Administrator admin);
}
