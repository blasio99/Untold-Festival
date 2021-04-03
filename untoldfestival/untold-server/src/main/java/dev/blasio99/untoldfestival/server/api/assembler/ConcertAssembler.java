package dev.blasio99.untoldfestival.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.blasio99.untoldfestival.common.dto.ConcertDTO;
import dev.blasio99.untoldfestival.server.model.Concert;

@Component
public class ConcertAssembler implements BaseAssembler<ConcertDTO, Concert>{

    //private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd'T'hh:mm:ss.SSS");

	private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Concert createModel(ConcertDTO dto) {
        Concert concert = new Concert();
        concert.setId(dto.getId());
        concert.setTitle(dto.getTitle());
        concert.setGenre(dto.getGenre());
        concert.setMaxNrOfTickets(dto.getMaxNrOfTickets());
        concert.setStartDate(LocalDateTime.parse(dto.getStartDate(), dtf));
		System.out.println("  ----------------- " + concert.getStartDate());
        concert.setEndDate(LocalDateTime.parse(dto.getEndDate(), dtf));
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
        dto.setStartDate(dtf.format(model.getStartDate()));
        dto.setEndDate(dtf.format(model.getEndDate()));
        return dto;
    }
    
}
