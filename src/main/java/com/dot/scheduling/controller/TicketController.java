package com.dot.scheduling.controller;

import com.dot.scheduling.dto.TicketDTO;
import com.dot.scheduling.model.Ticket;
import com.dot.scheduling.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketRequest) {
        try {
            Ticket ticket = ticketService.createTicket(
                ticketRequest.getPersonId(), 
                ticketRequest.getTitle(), 
                ticketRequest.getDescription()
            );
            return ResponseEntity.ok(new TicketDTO(ticket.getPerson().getId(), ticket.getTitle(), ticket.getDescription()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);

        }
    }
    
}
