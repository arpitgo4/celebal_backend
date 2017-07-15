package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.dao.ISignUpDAO;
import com.eze.ai.api.models.Signup;
@Service
public class SignUpService implements ISignUpService{
	@Autowired
	private ISignUpDAO signupDao;	

	@Override
	public boolean SignIn(Signup signUp) {
		if(signupDao.Sign(signUp.getEmailId(), signUp.getPassword())){
			return true;
		}else
			return false;
	}
	
	@Override
	public boolean addSignUpDetails(Signup signup) {
		System.out.println("signup"+signup.getEmailId());
		if(signupDao.SignUpExists(signup.getEmailId())){
			return false;
		}else{
			signupDao.addSignUpDetails(signup);
			return true;
		}	
	
	}
	@Override
	public Signup getEmailId(String emailId) {
		Signup signup=signupDao.getEmailId(emailId);
		return signup;
	}
	@Override
	public List<Signup> getAllSignupDetails() {
	return signupDao.getAllSignupDetails();
	}
}
