package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.Signup;

public interface ISignUpDAO {
	
	void addSignUpDetails(Signup signUp);
	Signup getEmailId(String emailId);
	boolean SignUpExists(String emailId);
	List<Signup> getAllSignupDetails();
	boolean Sign(String emailId, String password);
}
