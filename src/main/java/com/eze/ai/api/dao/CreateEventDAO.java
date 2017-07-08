package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.CreateEvents;


@Transactional
@Repository
public class CreateEventDAO implements ICreateEventDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<CreateEvents> getAllEvents() {
		String hql="FROM CreateEvents as event order by event.eventId";
		
		return (List<CreateEvents>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addAllEvents(CreateEvents events) {
		entityManager.persist(events);
		
	}

	@Override
	public CreateEvents getEventById(int eventId) {
		return entityManager.find(CreateEvents.class, eventId);
	}

	@Override
	public boolean eventExists(String eventName, String eventLocation) {
		String hql="FROM CreateEvents as event where event.eventName=? and event.eventLocation=?";
		int count=entityManager.createQuery(hql).setParameter(1, eventName).setParameter(2, eventLocation).getResultList().size();
		return count>0 ? true:false;
	}
}
