package dev.blasio99.untoldfestival.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.blasio99.untoldfestival.common.dto.ConcertDTO;

import dev.blasio99.untoldfestival.server.model.Concert;

@Component
public class ConcertAssembler implements BaseAssembler<ConcertDTO, Concert>{

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd'T'hh:mm:ss.SSS");

    @Override
    public Concert createModel(ConcertDTO dto) {
        Concert concert = new Concert();
        concert.setId(dto.getId());
        concert.setTitle(dto.getTitle());
        concert.setGenre(dto.getGenre());
        concert.setMaxNrOfTickets(dto.getMaxNrOfTickets());
        concert.setStartTime(LocalDateTime.parse(dto.getStartDate(), dtf));
        concert.setEndTime(LocalDateTime.parse(dto.getEndDate(), dtf));
        return concert;
    }

    @Override
    public ConcertDTO createDTO(Concert model) {
        ConcertDTO dto = new ConcertDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setGenre(model.getGenre());
        dto.setPerformer(model.getPerformer());
        dto.setMaxNrOfTickets(model.getMaxNrOfTickets());
        dto.setStartDate(model.getStartTime().format(dtf));
        dto.setEndDate(model.getEndTime().format(dtf));
        return dto;
    }
    
}
