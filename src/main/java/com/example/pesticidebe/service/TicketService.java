package com.example.pesticidebe.service;

import com.example.pesticidebe.dao.TicketDao;
import com.example.pesticidebe.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// THIS IS INTERACTING WITH OUR DATABASE "OUR DAO"

@Service
public class TicketService {

    private final TicketDao ticketDao;

    @Autowired
    public TicketService(@Qualifier("fakeDao") TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public long addTicket(Ticket ticket) {
        return ticketDao.insertTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketDao.selectAllTickets();
    }

    public Optional<Ticket> getTicketById(int id) {
        return ticketDao.selectTicketById(id);
    }

    public long deleteTicket(int id) {
        return ticketDao.deleteTicketById(id);
    }

    public long updateTicket(int id, Ticket newTicket) {
        return ticketDao.updateTicketById(id, newTicket);
    }

}
