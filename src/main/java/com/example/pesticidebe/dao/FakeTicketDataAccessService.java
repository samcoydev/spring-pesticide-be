package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeTicketDataAccessService implements TicketDao {

    private static List<Ticket> DB = new ArrayList<>();

    @Override
    public int insertTicket(UUID id, Ticket ticket) {
        DB.add(new Ticket(id, ticket.getTitle()));
        return 1;
    }

    @Override
    public List<Ticket> selectAllTickets() {
        return DB;
    }

    @Override
    public Optional<Ticket> selectTicketById(UUID id) {
        return DB.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTicketById(UUID id) {
        Optional<Ticket> ticketMaybe = selectTicketById(id);
        if (!ticketMaybe.isPresent()) {
            return 0;
        }
        DB.remove(ticketMaybe.get());
        return 1;
    }

    @Override
    public int updateTicketById(UUID id, Ticket update) {
        return selectTicketById(id)
                .map(t -> {
                    int indexOfTicketToUpdate = DB.indexOf(t);
                    if(indexOfTicketToUpdate >= 0) {
                        DB.set(indexOfTicketToUpdate, new Ticket(id, update.getTitle()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
