package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.CreateEvents;


public interface ICreateEventService {
	
	List<CreateEvents> getAllEvents();
	boolean addAllEvents(CreateEvents events);
	CreateEvents getEventById(int eventId);
	
	

}
