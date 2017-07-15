package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.eze.ai.api.dao.ICreateEventDAO;
import com.eze.ai.api.models.CreateEvents;
@Service
public class CreateEventService implements ICreateEventService{
	@Autowired
	private ICreateEventDAO eventDao;

	@Override
	public List<CreateEvents> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public boolean addAllEvents(CreateEvents events) {
		if(eventDao.eventExists(events.getEventName(), events.getEventLocation())){
			return false;
		}
		eventDao.addAllEvents(events);
		return true;
		
	}

	@Override
	public CreateEvents getEventById(int eventId) {
		CreateEvents events=eventDao.getEventById(eventId);
		return events;
	}

	

}
