package com.quocviet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quocviet.domain.Greeting;

@Repository
public class GreetingDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Greeting> getAllGreetings() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("select g from Greeting g order by id desc");
		@SuppressWarnings("unchecked")
		List<Greeting> greetingList = q.list();
		return greetingList;
	}
	
	public void addGreeting(Greeting greeting) {
		Session session = sessionFactory.getCurrentSession();
		session.save(greeting);
	}
}
