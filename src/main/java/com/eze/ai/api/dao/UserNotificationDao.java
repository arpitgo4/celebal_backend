package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.UserNotifications;

@Transactional
@Repository
public class UserNotificationDao implements IUserNotificationDao{
	@PersistenceContext
	private EntityManager entityManager; 

	@Override
	public void addUserNotifications(UserNotifications notification) {
		entityManager.persist(notification);
		
	}

	@Override
	public UserNotifications getNotificationById(int userId) {
		return entityManager.find(UserNotifications.class,userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserNotifications> getAllNotifications() {
		String hql="From UserNotifications as user order by user.userId";
		return (List<UserNotifications>)entityManager.createQuery(hql).getResultList();
	}

}
