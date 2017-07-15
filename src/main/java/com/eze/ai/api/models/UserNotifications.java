package com.eze.ai.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_notifications")
public class UserNotifications implements Serializable{
	private static final long serialVersionUID = 7655934404073677894L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="daily_meeting_prep_email")
	private boolean dailyMeetings;
	
	@Column(name="meeting_about_tostart_email")
	private boolean meetingStartEmail;
	@Column(name="meetings_tips_advice")
	private boolean meetingsTips;
	@Column(name="meeting_feedback")
	private boolean meetingFeedback;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isDailyMeetings() {
		return dailyMeetings;
	}
	public void setDailyMeetings(boolean dailyMeetings) {
		this.dailyMeetings = dailyMeetings;
	}
	public boolean isMeetingStartEmail() {
		return meetingStartEmail;
	}
	public void setMeetingStartEmail(boolean meetingStartEmail) {
		this.meetingStartEmail = meetingStartEmail;
	}
	public boolean isMeetingsTips() {
		return meetingsTips;
	}
	public void setMeetingsTips(boolean meetingsTips) {
		this.meetingsTips = meetingsTips;
	}
	public boolean isMeetingFeedback() {
		return meetingFeedback;
	}
	public void setMeetingFeedback(boolean meetingFeedback) {
		this.meetingFeedback = meetingFeedback;
	}
	
	
	
	
	

}
