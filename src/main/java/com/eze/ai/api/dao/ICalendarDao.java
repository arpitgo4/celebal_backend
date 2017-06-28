package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.Calendar;

public interface ICalendarDao {
	Calendar getEventsById(int calendarId);
	List<Calendar> getAllCalendarDetails();
	void AddCalendarDetails(Calendar calendar);
	void deleteCalendarDetails(int calendarId);
	

}
