package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.Calendar;

public interface ICalendarService {
	Calendar getEventsById(int calendarId);
	List<Calendar> getAllCalendarDetails();
	void addCalendarDetails(Calendar calendar);
	void deleteCalendarDetails(int calendarId);
}
