package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.dao.ICalendarDAO;
import com.eze.ai.api.models.EventCalendarData;
@Service
public class CalendarService implements ICalendarService{
	@Autowired
	private ICalendarDAO calendarDao;

	@Override
	public EventCalendarData getEventsById(int calendarId) {
		EventCalendarData obj= calendarDao.getEventsById(calendarId);
		return obj;
	}

	@Override
	public List<EventCalendarData> getAllCalendarDetails() {
		return calendarDao.getAllCalendarDetails();
		
	}

	@Override
	public void addCalendarDetails(EventCalendarData calendar) {
		calendarDao.AddCalendarDetails(calendar);
		
	}

	@Override
	public void deleteCalendarDetails(int calendarId) {
		calendarDao.deleteCalendarDetails(calendarId);
		
	}
	

}
