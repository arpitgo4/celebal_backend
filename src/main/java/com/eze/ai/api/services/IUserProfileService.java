package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.UserProfile;

public interface IUserProfileService {
	
	boolean addUserProfileDetails(UserProfile profile);
	UserProfile getProfileById(int userId);
	List<UserProfile> getAllUserProfiles();


}
