package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.CreateEvents;


public interface ICreateEventDao {
	
	List<CreateEvents> getAllEvents();
	void addAllEvents(CreateEvents event);
	CreateEvents getEventById(int eventId);
	boolean eventExists(String eventName,String eventLocation); 

}
