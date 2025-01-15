package com.dot.scheduling.service;

import com.dot.scheduling.mapper.PMapper;
import com.dot.scheduling.model.Person;
import com.dot.scheduling.model.Ticket;
import com.dot.scheduling.repositories.PersonRepository;
import com.dot.scheduling.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PersonRepository personRepository;

    public Ticket createTicket(Long personId, String title, String description) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent()) {
            Ticket ticket = new Ticket(title, description, person.get());
           ticketRepository.save(ticket);

           return PMapper.parseObject(ticket, Ticket.class);

        } else {
            throw new IllegalArgumentException("Person not found with ID: " + personId);
        }
    }
}
