package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketDao {

    int insertTicket(UUID id, Ticket ticket);

    default int insertTicket(Ticket ticket) {
        UUID id = UUID.randomUUID();
        return insertTicket(id, ticket);
    }

    List<Ticket> selectAllTickets();

    Optional<Ticket> selectTicketById(UUID id);

    int deleteTicketById(UUID id);

    int updateTicketById(UUID id, Ticket ticket);

}
