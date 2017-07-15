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
@Table (name="sign")
public class Signup implements Serializable {
    private static final long serialVersionUID = -436526222372424484L;
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="u_id")
    private int signupId;
    @Column(name = "u_email")
    private String emailId;
    @Column (name="u_name")
    private String name;
    @Column (name="u_password")
    private String password;
    @Column (name="u_address")
    private String address;
    
    

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSignupId() {
        return signupId;
    }
    public void setSignupId(int signupId) {
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
    return "SignUp [signupId="+ signupId +",name=" + name + ", emailId=" +emailId + ", password=" + password + ",address ="+address+"]";
    }*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="signup_id")
    private int signupId;
    @Column(name = "email_id")
    private String emailId;
    @Column (name="name")
    private String name;
    @Column (name="password")
    private String password;
    @Column (name="date_of_birth")
    private String dateOfBirth;
	
    
    public int getSignupId() {
		return signupId;
	}
	public void setSignupId(int signupId) {
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	 @Override
	    public String toString() {
	    return "SignUp [signupId="+ signupId +",name=" + name + ", emailId=" +emailId + ", password=" + password + ",dateOfBirth ="+dateOfBirth+"]";
	    }
}