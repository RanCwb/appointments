package com.dot.scheduling.repositories;

import com.dot.scheduling.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
