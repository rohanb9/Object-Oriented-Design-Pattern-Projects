package com.buffermanagement.classes;

public class Request {
	private String type;
	private String desc;
	
	public Request(String type) {
		this.setType(type);
	}
	
	public Request(String type, String desc) {
		this.setType(type);
		this.setDesc(desc);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
