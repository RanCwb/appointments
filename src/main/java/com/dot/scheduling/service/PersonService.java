package com.dot.scheduling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.scheduling.model.Person;
import com.dot.scheduling.repositories.PersonRepository;


@Service
public class PersonService {

    @Autowired
    public  PersonRepository personRepository;

    public Person createPerson(Person person) {

        validadePersonFields(person);
        
        personRepository.save(person);
        
        return person;
    }


    public List<Person> getAllPersons() {

        if (personRepository.findAll().isEmpty()) {
            throw new RuntimeException("No person found");
            
        }
        
        return personRepository.findAll();
    }


    public Person updatePerson(Person person) {
        Optional<Person> existingPerson = personRepository.findById(person.getId());
    
        if (existingPerson.isEmpty()) {
            throw new RuntimeException("Person not found with ID: " + person.getId());
        }
        validadePersonFields(person);
        return personRepository.save(person);
    }
    
    public void deletePerson(Long id) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isEmpty()) {
            throw new RuntimeException("Person not found with ID: " + id);
        }
        personRepository.deleteById(id);
    }

    public Person getPerson(Long id) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isEmpty()) {
            throw new RuntimeException("Person not found with ID: " + id);
        }
        return existingPerson.get();

    }

    public Boolean validadePersonFields(Person person ) {
        if(person.getName().isEmpty() || person.getAge() == 0 || person.getPhone().isEmpty() || person.getAddress().isEmpty() || person.getEmail().isEmpty()) {
            throw new  RuntimeException("All fields are required");
        }
        return true;    
    }

}
