package dev.blasio99.untoldfestival.server.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.blasio99.untoldfestival.common.dto.TicketDTO;

import dev.blasio99.untoldfestival.server.model.Ticket;
import dev.blasio99.untoldfestival.server.repo.ConcertRepository;

@Component
public class TicketAssembler implements BaseAssembler<TicketDTO, Ticket> {

    @Autowired
    private ConcertRepository concertRepository;

    @Override
    public Ticket createModel(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setPrice(dto.getPrice());
        ticket.setSeats(dto.getSeats());
        ticket.setConcert(concertRepository.findById(dto.getConcertId()).orElse(null));
        return ticket;
    }

    @Override
    public TicketDTO createDTO(Ticket model) {
        TicketDTO dto = new TicketDTO();
        dto.setPrice(model.getPrice());
        dto.setSeats(model.getSeats());
        dto.setId(model.getId());
        dto.setConcertId(model.getConcert().getId());
        return dto;
    }
}