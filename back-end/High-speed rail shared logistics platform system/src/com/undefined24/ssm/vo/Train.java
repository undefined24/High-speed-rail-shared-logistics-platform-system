package com.undefined24.ssm.vo;

public class Train {
	private String startpoint;
	private String trainnumber;
	private String traintime;
	private String arrivepoint;
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getTraintime() {
		return traintime;
	}
	public void setTraintime(String traintime) {
		this.traintime = traintime;
	}
	public String getArrivepoint() {
		return arrivepoint;
	}
	public void setArrivepoint(String arrivepoint) {
		this.arrivepoint = arrivepoint;
	}
	@Override
	public String toString() {
		return "Train [startpoint=" + startpoint + ", trainnumber=" + trainnumber + ", traintime=" + traintime
				+ ", arrivepoint=" + arrivepoint + "]";
	}
	
	
}
