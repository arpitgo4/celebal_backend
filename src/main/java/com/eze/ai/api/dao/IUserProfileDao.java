package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.UserProfile;

public interface IUserProfileDao {
	
	void addUserProfileDetails(UserProfile profile);
	UserProfile getProfileById(int userId);
	boolean profileExists(String emailId);
	List<UserProfile> getAllUserProfiles();

}
