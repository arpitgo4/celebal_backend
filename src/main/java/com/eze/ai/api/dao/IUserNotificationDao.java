package com.eze.ai.api.dao;



import java.util.List;

import com.eze.ai.api.models.UserNotifications;

public interface IUserNotificationDao {
	
	void addUserNotifications(UserNotifications notification);
	UserNotifications getNotificationById(int userId);
	List<UserNotifications> getAllNotifications();

}
