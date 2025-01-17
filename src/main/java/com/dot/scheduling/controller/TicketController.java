package com.dot.scheduling.controller;

import com.dot.scheduling.dto.TicketDTO;
import com.dot.scheduling.model.Ticket;
import com.dot.scheduling.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("userTicket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        try {
            Ticket ticket = ticketService.getTicket(id);
            return ResponseEntity.ok(ticket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("userTickets/{id}")
    public ResponseEntity<Object> getTickets(@PathVariable Long id) {
        try {
            List<Ticket> tickets = ticketService.getAllTicketsForPersonId(id);
            return ResponseEntity.ok(tickets);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Bad Request");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("timestamp", LocalDateTime.now().toString());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        try {
            ticketService.deleteTicket(id);
            return ResponseEntity.ok("Ticket deleted");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error deleting ticket: " + e.getMessage());
        }
    }
}
