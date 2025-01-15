package com.dot.scheduling.controller;
import org.springframework.web.bind.annotation.RestController;
import com.dot.scheduling.model.Person;
import com.dot.scheduling.service.PersonService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    public  PersonService personService;
        
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/create")
    public ResponseEntity<String>createPerson(@RequestBody Person person  ){
        try {
            personService.createPerson(person);
            return new ResponseEntity<>("Person created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating person", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public String updatePersonById(@PathVariable String id, @RequestBody Person person) {
        try {
            person.setId(Long.parseLong(id));
            personService.updatePerson(person);
            return "Person updated";
        } catch (Exception e) {
            return "Error updating person: " + e.getMessage();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public String deletePersonById(@PathVariable String id) {
        try {
            personService.deletePerson(Long.parseLong(id));
            return "Person deleted";
        } catch (Exception e) {
            return "Error deleting person: " + e.getMessage();
        }
    }

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        try {
            return personService.getAllPersons();
        } catch (Exception e) {
            throw new RuntimeException("No person found");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getPersonDetail(@PathVariable Long id) {
        try {
            
            return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Person not found with ID: " + id, HttpStatus.NOT_FOUND);
        }

    }

    
    

}
