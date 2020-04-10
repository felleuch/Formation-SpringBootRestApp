package com.journaldev.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	
	@Autowired
	PersonService personService;
	
	List<Person>   listPerson=new ArrayList<Person>();

	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	
	
	@RequestMapping(value="/person/all",method=RequestMethod.GET, produces  =MediaType.APPLICATION_XML_VALUE)
	public List<Person> getPerson() {
		
		return listPerson;
	}
	
	@RequestMapping("/person/get")
	public Person getPerson(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
		person.setName(name);
		return person;
	}
	
	@RequestMapping(value="/person/create", method=RequestMethod.POST, consumes = "application/json")
	public Person createPerson(@RequestBody Person p) {
		
		personService.addPerson(p);
		listPerson.add(p);
		return person;
	}
	
//	@RequestMapping(value="/person/update", method=RequestMethod.POST)
//	public Person updatePerson(@RequestParam(name="name", required=true) String name) {
//		person.setName(name);
//		return person;
//	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.POST, consumes = "application/json")
	public Person updatePerson(@RequestBody Person p) {
		person.setName(p.getName());
		return person;
	}
}
