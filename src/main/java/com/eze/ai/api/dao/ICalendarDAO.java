package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.EventCalendarData;

public interface ICalendarDAO {
	EventCalendarData getEventsById(int calendarId);
	List<EventCalendarData> getAllCalendarDetails();
	void AddCalendarDetails(EventCalendarData calendar);
	void deleteCalendarDetails(int calendarId);
	

}
