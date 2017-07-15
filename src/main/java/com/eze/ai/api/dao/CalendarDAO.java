package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.EventCalendarData;
import com.eze.ai.api.models.OutlookCalendarData;
@Transactional
@Repository
public class CalendarDAO implements ICalendarDAO,Constant{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EventCalendarData getEventsById(int calendarId) {
		return entityManager.find(EventCalendarData.class, calendarId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EventCalendarData> getAllCalendarDetails() {
		String hql=Constant.GOOGLE_CALENDAR;
		return (List<EventCalendarData>) entityManager.createQuery(hql).getResultList();
	}
	
	

	@Override
	public void AddGoogleCalendarDetails(EventCalendarData calendar) {
		String hql = "FROM EventCalendarData as event WHERE event.eventId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, calendar.getEventId())
		              .getResultList().size();
		if(count>0){
		}else{
			entityManager.persist(calendar);	
		}	
		
	}
	
	@Override
	public void deleteCalendarDetails(int calendarId) {
		entityManager.remove(getEventsById(calendarId));
	}
	@Override
	public void AddOutlookCalendarDetails(OutlookCalendarData calendar) {
		String hql=Constant.OUTLOOK_CALENDAR;
		//entityManager.createQuery(hql).setParameter(1, calendar.getEventId()).getResultList().size();
		entityManager.persist(calendar);
	}
	
	
	

}
