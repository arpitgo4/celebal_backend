package com.eze.ai.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eze.ai.api.models.Signup;

@Transactional
@Repository
public class SignUpDAO implements ISignUpDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public void addSignUpDetails(Signup signUp) {
		entityManager.persist(signUp);
		
	}

	@Override
	public Signup getEmailId(String emailId) {
		return entityManager.find(Signup.class, emailId);
	}

	@Override
	public boolean SignUpExists(String emailId, String password) {
		String hql="FROM signup as signup where signup.emailId=? and signup.password=?";
		System.out.println("first hi");
		int count=entityManager.createQuery(hql).setParameter(1, emailId).setParameter(2, password)
		.getResultList().size();
		System.out.println("hi");
		return count>0 ?true:false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Signup> getAllSignupDetails() {
		String hql="FROM signup as sign order by sign.signup_id";
		
		return (List<Signup>) entityManager.createQuery(hql).getResultList();
	}

}
