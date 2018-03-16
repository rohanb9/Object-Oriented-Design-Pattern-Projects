package com.buffermanagement.exception;

public class BBException extends Exception 
{
	private String msg;
	  
	public BBException(String msg) {
	   this.setMsg(msg);
	   
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
  
}