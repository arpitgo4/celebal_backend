package com.eze.ai.api.services;


import java.util.List;

import com.eze.ai.api.models.UserNotifications;

public interface IUserNotificationService {
	
	void addUserNotification(UserNotifications notifications);
	UserNotifications getNotificationById();
	List<UserNotifications> getAllNotifications();

}
