package com.undefined24.ssm.vo;

public class Bill {
	private int trackingID;
	private int giveUserID;
	private int acceptUserID;
	private String sendaddress;
	private String arriveaddress;
	private String trainnumber;
	private boolean complete;
	private float cost;
	private Goods goods;
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public int getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}
	public int getGiveUserID() {
		return giveUserID;
	}
	public void setGiveUserID(int giveUserID) {
		this.giveUserID = giveUserID;
	}
	public int getAcceptUserID() {
		return acceptUserID;
	}
	public void setAcceptUserID(int acceptUserID) {
		this.acceptUserID = acceptUserID;
	}
	public String getSendaddress() {
		return sendaddress;
	}
	public void setSendaddress(String sendaddress) {
		this.sendaddress = sendaddress;
	}
	public String getArriveaddress() {
		return arriveaddress;
	}
	public void setArriveaddress(String arriveaddress) {
		this.arriveaddress = arriveaddress;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bill [trackingID=" + trackingID + ", giveUserID=" + giveUserID + ", acceptUserID=" + acceptUserID
				+ ", sendaddress=" + sendaddress + ", arriveaddress=" + arriveaddress + ", trainnumber=" + trainnumber
				+ ", complete=" + complete + ", cost=" + cost + ", gooods=" + goods + "]";
	}
	
}
