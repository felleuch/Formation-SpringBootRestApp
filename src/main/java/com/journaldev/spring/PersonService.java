package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	PersonDao  personDao;

	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
