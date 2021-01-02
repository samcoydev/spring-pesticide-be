package com.example.pesticidebe.service.impl;

import com.example.pesticidebe.dao.TicketDao;
import com.example.pesticidebe.dto.TicketDto;
import com.example.pesticidebe.model.Ticket;
import com.example.pesticidebe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "ticketService")
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDao ticketDao;

    public List<Ticket> findAll() {
        List<Ticket> list = new ArrayList<>();
        ticketDao.findByOrderById().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        Ticket t = ticketDao.findById(id).get();
        ticketDao.delete(t);
    }

    @Override
    public Ticket findById(Long id) { return ticketDao.findById(id).get(); }

    public Ticket save(TicketDto ticket) {
        Ticket newTicket = new Ticket();
        newTicket.setTitle(ticket.getTitle());
        newTicket.setDescription(ticket.getDescription());
        newTicket.setTimestamp(ticket.getTimestamp());
        newTicket.setAssignedUsername(ticket.getAssignedUsername());
        newTicket.setCreator(ticket.getCreator());
        newTicket.setPriorityLevel(ticket.getPriorityLevel());
        newTicket.setDeadline(ticket.getDeadline());
        newTicket.setStatus(ticket.getStatus());

        ticketDao.save(newTicket);

        return ticketDao.save(newTicket);
    }

    public Ticket update(long id, TicketDto ticket) {
        Optional<Ticket> optionalTicket = ticketDao.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket existingTicket = optionalTicket.get();
            existingTicket.setTitle(ticket.getTitle());
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setAssignedUsername(ticket.getAssignedUsername());
            existingTicket.setPriorityLevel(ticket.getPriorityLevel());
            existingTicket.setDeadline(ticket.getDeadline());
            existingTicket.setStatus(ticket.getStatus());

            return ticketDao.save(existingTicket);
        } else {
            return null;
        }
    }

}
