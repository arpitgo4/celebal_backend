package com.eze.ai.api.dao;

import java.util.List;

import com.eze.ai.api.models.EventCalendarData;
import com.eze.ai.api.models.OutlookCalendarData;

public interface ICalendarDAO {
	EventCalendarData getEventsById(int calendarId);
	List<EventCalendarData> getAllCalendarDetails();
	void AddGoogleCalendarDetails(EventCalendarData calendar);
	void deleteCalendarDetails(int calendarId);
	
	void AddOutlookCalendarDetails(OutlookCalendarData calendar);
	

}
