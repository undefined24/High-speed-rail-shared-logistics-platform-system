package com.undefined24.ssm.vo;

public class User {
	private int userID;
	private String nickname;
	private String userpwd;
	private String useraddress;
	private String usersex;
	private String userbirthday;
	private String note;
	private String username;
	private String userphone;
	private String usernumber;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(String userbirthday) {
		this.userbirthday = userbirthday;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
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
	@Override
	public String toString() {
		return "User [userID=" + userID + ", nickname=" + nickname + ", userpwd=" + userpwd + ", useraddress="
				+ useraddress + ", usersex=" + usersex + ", userbirthday=" + userbirthday + ", note=" + note
				+ ", username=" + username + ", userphone=" + userphone + ", usernumber=" + usernumber + "]";
	}
	
	
}