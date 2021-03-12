package dev.blasio99.untoldfestival.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.untoldfestival.common.dto.TicketDTO;

import dev.blasio99.untoldfestival.server.api.assembler.TicketAssembler;
import dev.blasio99.untoldfestival.server.model.Ticket;
import dev.blasio99.untoldfestival.server.service.ServiceException;
import dev.blasio99.untoldfestival.server.service.TicketService;

@RestController
public class TicketResource {
    

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketAssembler ticketAssembler;

    @GetMapping("/api/ticket/{concertId}")
    public List<TicketDTO> getTicketsForConcert(@PathVariable Long concertId) {
        return ticketAssembler.createDTOList(ticketService.getTicketsForConcert(concertId));
    }


    @PostMapping("/api/ticket/sell")
    public ResponseEntity<TicketDTO> addTicket(@RequestBody TicketDTO dto) {
        try {
            Ticket ticket = ticketService.addTicket(ticketAssembler.createModel(dto));
            return new ResponseEntity<>(ticketAssembler.createDTO(ticket), HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }
}