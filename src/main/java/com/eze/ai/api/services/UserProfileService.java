package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.dao.IUserProfileDao;
import com.eze.ai.api.models.UserProfile;
@Service
public class UserProfileService implements IUserProfileService{
	@Autowired
	IUserProfileDao profileDao; 
	@Override
	public boolean addUserProfileDetails(UserProfile profile) {
		if(profileDao.profileExists(profile.getEmailId())){
			return false;
		}else{
			profileDao.addUserProfileDetails(profile);
			System.out.println("dao");
			return true;
			
		}
		
		
	}

	@Override
	public UserProfile getProfileById(int userId) {
		return profileDao.getProfileById(userId);
		
	}

	@Override
	public List<UserProfile> getAllUserProfiles() {
		return profileDao.getAllUserProfiles();
	}

}
