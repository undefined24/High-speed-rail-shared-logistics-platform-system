package com.undefined24.ssm.vo;

public class History {
	private int historyID;
	private int giveUserID;
	private int acceptUserID;
	private int trackingID;
	public int getHistoryID() {
		return historyID;
	}
	public void setHistoryID(int historyID) {
		this.historyID = historyID;
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
	public int getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}
	@Override
	public String toString() {
		return "History [historyID=" + historyID + ", giveUserID=" + giveUserID + ", acceptUserID=" + acceptUserID
				+ ", trackingID=" + trackingID + "]";
	}
	
}
