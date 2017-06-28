package com.eze.ai.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eze.ai.api.dao.ICalendarDao;
import com.eze.ai.api.models.Calendar;
@Service
public class CalendarService implements ICalendarService{
	@Autowired
	private ICalendarDao calendarDao;

	@Override
	public Calendar getEventsById(int calendarId) {
		Calendar obj= calendarDao.getEventsById(calendarId);
		return obj;
	}

	@Override
	public List<Calendar> getAllCalendarDetails() {
		return calendarDao.getAllCalendarDetails();
		
	}

	@Override
	public void addCalendarDetails(Calendar calendar) {
		calendarDao.AddCalendarDetails(calendar);
		
	}

	@Override
	public void deleteCalendarDetails(int calendarId) {
		calendarDao.deleteCalendarDetails(calendarId);
		
	}
	

}
