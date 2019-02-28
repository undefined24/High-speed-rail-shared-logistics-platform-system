package com.undefined24.ssm.vo;

public class Receiver {
	public int trackingID;
	public String name;
	public String phone;
	public String address;
	public int getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Receiver [trackingID=" + trackingID + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
}
