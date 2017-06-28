package com.eze.ai.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="signup")
public class Signup implements Serializable {
	private static final long serialVersionUID = -436526222372424484L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="signup_id")
	private Integer signupId;
	@Column(name = "email_id")
	private String emailId;
	@Column (name="name")
	private String name;
	@Column (name="password")
	private String password;
	@Column (name="date_of_birth")
	private Date dateOfBirth;
	
	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getSignupId() {
		return signupId;
	}
	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
	return "SignUp [signupId="+ signupId +",name=" + name + ", emailId=" +emailId + ", password=" + password + ",dateOfBirth="+dateOfBirth+"]";
	}
	
	
}
