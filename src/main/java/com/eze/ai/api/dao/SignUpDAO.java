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
	public boolean SignUpExists(String emailId) {
		String hql="FROM Signup as signup where signup.emailId=?";
		int count=entityManager.createQuery(hql).setParameter(1, emailId).getResultList().size();
		System.out.println(count);
		return count>0 ?true:false;
	}
	@Override
	public boolean Sign(String emailId, String password) {
		String hql="FROM Signup as signup where signup.emailId=? and signup.password=?";
		int count=entityManager.createQuery(hql).setParameter(1, emailId).setParameter(2, password)
		.getResultList().size();
		return count>0 ?true:false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Signup> getAllSignupDetails() {
		String hql="FROM Signup as sign order by sign.signup_id";
		
		return (List<Signup>) entityManager.createQuery(hql).getResultList();
	}

}
