package com.undefined24.ssm.vo;

public class Worker {
	private int workerID;
	private String workername;
	private String workersex;
	private String workerposition;
	private int workersalary;
	private int workercheckcard;
	public int getWorkerID() {
		return workerID;
	}
	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	public String getWorkersex() {
		return workersex;
	}
	public void setWorkersex(String workersex) {
		this.workersex = workersex;
	}
	public String getWorkerposition() {
		return workerposition;
	}
	public void setWorkerposition(String workerposition) {
		this.workerposition = workerposition;
	}
	public int getWorkersalary() {
		return workersalary;
	}
	public void setWorkersalary(int workersalary) {
		this.workersalary = workersalary;
	}
	public int getWorkercheckcard() {
		return workercheckcard;
	}
	public void setWorkercheckcard(int workercheckcard) {
		this.workercheckcard = workercheckcard;
	}
	@Override
	public String toString() {
		return "worker [workerID=" + workerID + ", workername=" + workername + ", workersex=" + workersex
				+ ", workerposition=" + workerposition + ", workersalary=" + workersalary + ", workercheckcard="
				+ workercheckcard + "]";
	}
	
}
