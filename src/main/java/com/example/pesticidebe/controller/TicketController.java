package com.example.pesticidebe.controller;

import com.example.pesticidebe.dto.TicketDto;
import com.example.pesticidebe.model.Ticket;
import com.example.pesticidebe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/ticket")
@Table(name = "tickets")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        System.out.println("getting tickets");
        return ticketService.findAll();
    }

    @PostMapping
    public Ticket saveTicket(@Valid @RequestBody TicketDto ticket) {
        System.out.println("saving ticket");
        return ticketService.save(ticket);
    }

}