
package com.dot.scheduling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dot.scheduling.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    
}