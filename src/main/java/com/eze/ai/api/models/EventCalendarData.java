package com.eze.ai.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="calendar")
public class EventCalendarData implements Serializable{
	private static final long serialVersionUID = 3919675413983934062L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="calendar_id")
	private int calendarId;
	@Column(name="event_name")
	private String eventName;
	@Column(name="event_location")
	private String eventLocation;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	@Column(name="attendee")
	private String attendee;
	
	public EventCalendarData(){}
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
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
	public String getAttendee() {
		return attendee;
	}
	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}
		
}
