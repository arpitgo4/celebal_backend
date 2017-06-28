package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.Calendar;
@Transactional
@Repository
public class CalendarDao implements ICalendarDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Calendar getEventsById(int calendarId) {
		return entityManager.find(Calendar.class, calendarId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Calendar> getAllCalendarDetails() {
		String hql="FROM Calendar as calendar order by calendar.calendar_id";
		return (List<Calendar>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void AddCalendarDetails(Calendar calendar) {
		entityManager.persist(calendar);
		
	}
	@Override
	public void deleteCalendarDetails(int calendarId) {
		entityManager.remove(getEventsById(calendarId));
	}
	
	
	

}
