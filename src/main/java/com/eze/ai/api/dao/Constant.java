package com.eze.ai.api.dao;

public interface Constant {
	
	String GOOGLE_CALENDAR="FROM EventCalendarData as calendar order by calendar.calendarId";
	String OUTLOOK_CALENDAR="FROM EventCalendarData as event WHERE event.eventId = ?";
	
	

}
