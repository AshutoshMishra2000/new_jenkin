package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonService {
	
	Person createPerson(Person person);
    List<Person> getPersonsList();
}

