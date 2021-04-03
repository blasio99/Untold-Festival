package dev.blasio99.untoldfestival.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.blasio99.untoldfestival.server.model.Ticket;
import dev.blasio99.untoldfestival.server.repo.TicketRepository;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTicketsForConcert(Long concertId) {
        return ticketRepository.findByConcertId(concertId);
    }

    public Ticket addTicket(Ticket ticket) throws ServiceException {
        List<Ticket> tickets = getTicketsForConcert(ticket.getConcert().getId());
        Long nrOfTicketsSold = tickets.stream().map(t -> t.getSeats()).reduce(0L, Long::sum);
        if (nrOfTicketsSold + ticket.getSeats() > ticket.getConcert().getMaxNrOfTickets()) {
            throw new ServiceException("Sold out", HttpStatus.CONFLICT) ;
        }
        return ticketRepository.save(ticket);
    }
}