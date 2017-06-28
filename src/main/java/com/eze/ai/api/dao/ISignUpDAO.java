package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.Signup;

public interface ISignUpDAO {
	
	void addSignUpDetails(Signup signUp);
	Signup getEmailId(String emailId);
	boolean SignUpExists(String emailId,String password);
	List<Signup> getAllSignupDetails();
}
