package com.undefined24.ssm.vo;

public class Worker {
	private int workerID;
	private String workername;
	private String workersex;
	private String workerposition;
	private String workersalary;
	private String workercheckcard;
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
	public String getWorkersalary() {
		return workersalary;
	}
	public void setWorkersalary(String workersalary) {
		this.workersalary = workersalary;
	}
	public String getWorkercheckcard() {
		return workercheckcard;
	}
	public void setWorkercheckcard(String workercheckcard) {
		this.workercheckcard = workercheckcard;
	}
	@Override
	public String toString() {
		return "worker [workerID=" + workerID + ", workername=" + workername + ", workersex=" + workersex
				+ ", workerposition=" + workerposition + ", workersalary=" + workersalary + ", workercheckcard="
				+ workercheckcard + "]";
	}
	
}
