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
		String hql="FROM Calendar as calendar order by calendar.calendar_id";
		return (List<EventCalendarData>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void AddCalendarDetails(EventCalendarData calendar) {
		entityManager.persist(calendar);
		
	}
	@Override
	public void deleteCalendarDetails(int calendarId) {
		entityManager.remove(getEventsById(calendarId));
	}
	
	
	

}
