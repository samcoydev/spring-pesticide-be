package com.example.pesticidebe.api;

import com.example.pesticidebe.model.Ticket;
import com.example.pesticidebe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

// THIS IS WHERE WE DEFINE ROUTING FOR /TICKET

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public void addTicket(@Valid @NonNull @RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping(path = "{id}")
    public Ticket getTicketById(@PathVariable("id") int id) {
        return ticketService.getTicketById(id)
                .orElse( null);
    }

    @DeleteMapping(path="{id}")
    public void deleteTicketById(@PathVariable("id") int id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping(path="{id}")
    public void updateTicket(@PathVariable("id") int id, @Valid @NonNull @RequestBody Ticket ticketToUpdate) {
        ticketService.updateTicket(id, ticketToUpdate);
    }
}
