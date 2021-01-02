package com.example.pesticidebe.service;

import com.example.pesticidebe.dto.TicketDto;
import com.example.pesticidebe.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket save(TicketDto ticket);
    Ticket update(long id, TicketDto ticket);

    List<Ticket> findAll();
    void delete(long id);

    Ticket findById(Long id);

}
