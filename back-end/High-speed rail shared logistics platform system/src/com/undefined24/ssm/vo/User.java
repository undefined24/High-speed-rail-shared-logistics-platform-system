package com.undefined24.ssm.vo;

public class User {
	private String username;
	private String userphone;
	private String usernumber;
	private String usersex;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", userphone=" + userphone + ", usernumber=" + usernumber + ", usersex="
				+ usersex + "]";
	}
	
}
