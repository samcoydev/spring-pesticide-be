package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.Ticket;

import java.util.List;
import java.util.Optional;

// What is the point of having this?

public interface TicketDao {

    long insertTicket(long id, Ticket ticket, String description);

    default long insertTicket(Ticket ticket) {
        long id = selectAllTickets().stream().count();
        return insertTicket(id, ticket, ticket.getDescription());
    }

    List<Ticket> selectAllTickets();

    Optional<Ticket> selectTicketById(long id);

    long deleteTicketById(long id);

    long updateTicketById(long id, Ticket ticket);

}
