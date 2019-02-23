package com.undefined24.ssm.vo;

public class Goods {
	private int trackingID;
	private float weight;
	private String type;
	private String name;
	private String note;
	private Bill bill;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Goods [trackingID=" + trackingID + ", weight=" + weight + ", type=" + type + ", name=" + name
				+ ", note=" + note + ", bill=" + bill + "]";
	}
	
}
