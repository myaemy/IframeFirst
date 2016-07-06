package com.example.aemy.iframefirst.beans;

public class User {
	private int result;
	private String errormsg;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public User(int result, String errormsg) {
		super();
		this.result = result;
		this.errormsg = errormsg;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
