package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	
	private final List<Person> personList = new ArrayList<>();

    public Person createPerson(Person person) {
    	 person.setId(System.currentTimeMillis());
       

        // Save the person to the local storage list
        personList.add(person);

        // Return the saved person
        return person;
    }
    @Override
    public List<Person> getPersonsList() {
        // Return the list of persons from local storage
        return personList;
    }
}


