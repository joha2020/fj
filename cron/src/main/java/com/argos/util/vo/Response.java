package com.argos.util.vo;

public class Response {
	
	private int estimatedWaitTime;
	private String id;
	private String validUntil;
	public int getEstimatedWaitTime() {
		return estimatedWaitTime;
	}
	public void setEstimatedWaitTime(int estimatedWaitTime) {
		this.estimatedWaitTime = estimatedWaitTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}

}
