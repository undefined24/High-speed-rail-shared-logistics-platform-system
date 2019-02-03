package com.undefined24.ssm.vo;

public class Administrator {
	private String adminID;
	private String adminname;
	private String adminpwd;
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	@Override
	public String toString() {
		return "Administrator [adminID=" + adminID + ", adminname=" + adminname + ", adminpwd=" + adminpwd + "]";
	}
	
}
