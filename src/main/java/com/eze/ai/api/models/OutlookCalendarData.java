package com.eze.ai.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="outlook_events")
public class OutlookCalendarData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="calendar_id")
	private int calendarId;
	
	@Column(name="event_id")
	private String eventId;
	
	@Column(name="event_name")
	private String eventName;
	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	@Column(name="event_location")
	private String eventLocation;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	@Column(name="attendees")
	private String attendees;
	
	@Column(name="event_description")
	private String eventDescription;

	

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAttendees() {
		return attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	
	

}
