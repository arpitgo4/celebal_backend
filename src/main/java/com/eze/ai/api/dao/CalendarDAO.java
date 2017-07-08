package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.EventCalendarData;
@Transactional
@Repository
public class CalendarDAO implements ICalendarDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EventCalendarData getEventsById(int calendarId) {
		return entityManager.find(EventCalendarData.class, calendarId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EventCalendarData> getAllCalendarDetails() {
		String hql="FROM EventCalendarData as calendar order by calendar.calendarId";
		return (List<EventCalendarData>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void AddCalendarDetails(EventCalendarData calendar) {
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
	
	
	

}
