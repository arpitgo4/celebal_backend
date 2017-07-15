package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.EventCalendarData;
import com.eze.ai.api.models.OutlookCalendarData;

public interface ICalendarService {
	EventCalendarData getEventsById(int calendarId);
	List<EventCalendarData> getAllCalendarDetails();
	void addGoogleCalendarDetails(EventCalendarData calendar);
	void deleteCalendarDetails(int calendarId);
	
	void addOutlookCalendarDetails(OutlookCalendarData calendar);
}
