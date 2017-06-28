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
	public boolean addSignUpDetails(Signup signup) {
		if(signupDao.SignUpExists(signup.getEmailId(), signup.getPassword())){
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
