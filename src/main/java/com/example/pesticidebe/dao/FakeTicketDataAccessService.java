package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// THIS IS ACTING AS OUR DATABASE

@Repository("fakeDao")
public class FakeTicketDataAccessService implements TicketDao {

    private static List<Ticket> DB = new ArrayList<>();

    @Override
    public long insertTicket(long id, Ticket ticket, String description) {
        DB.add(new Ticket(id, ticket.getTitle(), description));
        return 1;
    }

    @Override
    public List<Ticket> selectAllTickets() {
        return DB;
    }

    @Override
    public Optional<Ticket> selectTicketById(long id) {
        return DB.stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst();
    }

    @Override
    public long deleteTicketById(long id) {
        Optional<Ticket> ticketMaybe = selectTicketById(id);
        if (!ticketMaybe.isPresent()) {
            return 0;
        }
        DB.remove(ticketMaybe.get());
        return 1;
    }

    @Override
    public long updateTicketById(long id, Ticket update) {
        return selectTicketById(id)
                .map(t -> {
                    int indexOfTicketToUpdate = DB.indexOf(t);
                    if(indexOfTicketToUpdate >= 0) {
                        DB.set(indexOfTicketToUpdate, new Ticket(id, update.getTitle(), update.getDescription()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
