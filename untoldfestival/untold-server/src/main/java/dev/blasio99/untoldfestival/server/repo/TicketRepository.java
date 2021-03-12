package dev.blasio99.untoldfestival.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.untoldfestival.server.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    public List<Ticket> findByConcertId(Long id);
}