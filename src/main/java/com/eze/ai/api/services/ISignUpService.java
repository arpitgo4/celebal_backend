package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.Signup;

public interface ISignUpService {
		boolean addSignUpDetails(Signup signUp);
		Signup getEmailId(String emailId);
		List<Signup> getAllSignupDetails();
}
