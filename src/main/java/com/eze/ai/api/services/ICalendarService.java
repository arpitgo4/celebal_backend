package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.EventCalendarData;

public interface ICalendarService {
	EventCalendarData getEventsById(int calendarId);
	List<EventCalendarData> getAllCalendarDetails();
	void addCalendarDetails(EventCalendarData calendar);
	void deleteCalendarDetails(int calendarId);
}
