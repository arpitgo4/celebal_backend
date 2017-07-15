package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eze.ai.api.models.UserProfile;

@Transactional
@Repository
public class UserProfileDao implements IUserProfileDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUserProfileDetails(UserProfile profile) {
		entityManager.persist(profile);
		
	}

	@Override
	public UserProfile getProfileById(int userId) {
		return entityManager.find(UserProfile.class, userId);
	}

	@Override
	public boolean profileExists(String emailId) {
		String hql="From UserProfile as user where user.emailId=?";
		int count=entityManager.createQuery(hql).setParameter(1, emailId).getResultList().size();
		return count>0 ? true:false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfile> getAllUserProfiles() {
		String hql="From UserProfile as user order by user.userId";
		return (List<UserProfile>)entityManager.createQuery(hql).getResultList();
	}
	
	

}
