package com.undefined24.ssm.dao;

import java.util.List;

import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Worker;



public interface AdminMapper {
	public Administrator adminLogin(Administrator admin);
	public int adminChangePwd(Administrator admin);
	public int addWorker(Worker worker);
	public Worker checkWorker(Worker worker);
	public List<Worker> showWorker();
}