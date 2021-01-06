package com.example.pesticidebe.controller;

import com.example.pesticidebe.dto.TicketDto;
import com.example.pesticidebe.model.Ticket;
import com.example.pesticidebe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
// THIS IS WHERE WE DEFINE ROUTING FOR /TICKET

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Ticket> getAllTickets() {
        System.out.println("getting tickets");
        return ticketService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Ticket saveTicket(@Valid @RequestBody TicketDto ticket) {
        System.out.println("saving ticket");
        return ticketService.save(ticket);
    }

}
