package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.models.UserNotifications;
@Service
public class UserNotificationService implements IUserNotificationService{

	@Autowired
	
	@Override
	public UserNotifications getNotificationById() {
		return null;
	}

	@Override
	public List<UserNotifications> getAllNotifications() {
		return null;
	}

	@Override
	public void addUserNotification(UserNotifications notifications) {
		
	}

}
