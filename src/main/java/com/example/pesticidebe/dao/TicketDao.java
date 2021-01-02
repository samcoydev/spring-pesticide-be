package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Long> {

    Set<Ticket> findByOrderById();

    Optional<Ticket> findById(Long id);

}
