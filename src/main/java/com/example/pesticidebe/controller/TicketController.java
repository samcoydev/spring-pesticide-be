package com.example.pesticidebe.controller;

import com.example.pesticidebe.model.Ticket;
import com.example.pesticidebe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// THIS IS WHERE WE DEFINE ROUTING FOR /TICKET

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

}
