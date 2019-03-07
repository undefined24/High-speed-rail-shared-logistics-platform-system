package com.undefined24.ssm.vo;

public class Goods {
	private int trackingID;
	private float weight;
	private String type;
	private String name;
	private String picture;
	private Bill bill;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Goods [trackingID=" + trackingID + ", weight=" + weight + ", type=" + type + ", name=" + name
				+ ", picture=" + picture + ", bill=" + bill + "]";
	}
	
}
