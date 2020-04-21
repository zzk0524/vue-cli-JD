package com.ls.bean;

public class Account {
	int id;
	String account;
	String sex;
	String password;
	String favourite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFavourite() {
		return favourite;
	}
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", sex=" + sex + ", password=" + password + ", favourite="
				+ favourite + "]";
	}
	
}
