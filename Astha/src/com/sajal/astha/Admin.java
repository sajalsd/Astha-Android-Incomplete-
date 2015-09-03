package com.sajal.astha;

public class Admin {

	public String name;
	public String phone;
	public String username;
	public Admin(String name, String phone, String username, String passward) {
		super();
		this.name = name;
		this.phone = phone;
		this.username = username;
		this.passward = passward;
	}
	public String passward;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
}
