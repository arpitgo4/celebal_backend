package com.eze.ai.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="create_events")
public class CreateEvents implements Serializable{
	private static final long serialVersionUID = 5828453426594807183L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventId;
	@Column(name="event_name")
	private String eventName;
	@Column(name="event_location")
	private String eventLocation;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	@Column(name="event_description")
	private String eventDescription;
	@Column(name="attendee")
	private String eventAttendee;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventAttendee() {
		return eventAttendee;
	}
	public void setEventAttendee(String eventAttendee) {
		this.eventAttendee = eventAttendee;
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
	

}
