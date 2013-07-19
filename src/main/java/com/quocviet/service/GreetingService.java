package com.quocviet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quocviet.dao.GreetingDao;
import com.quocviet.domain.Greeting;

@Service
@Transactional
public class GreetingService {

	@Autowired
	private GreetingDao greetingDao;
	
	public void addGreeting(Greeting greeting) {
		greetingDao.addGreeting(greeting);
	}
	
	public List<Greeting> getAllGreetings() {
		return greetingDao.getAllGreetings();
	}
}
