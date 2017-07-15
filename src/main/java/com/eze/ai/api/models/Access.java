package com.eze.ai.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Access {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accessToken;
	private String emailId;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String toString(){
		return "Access [accessToken="+accessToken+",emailId="+emailId+"]";
	}

}
