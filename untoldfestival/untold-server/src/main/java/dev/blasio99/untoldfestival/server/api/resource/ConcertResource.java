package dev.blasio99.untoldfestival.server.api.resource;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.untoldfestival.common.dto.ConcertDTO;

import dev.blasio99.untoldfestival.server.api.assembler.ConcertAssembler;
import dev.blasio99.untoldfestival.server.enums.Genres;
import dev.blasio99.untoldfestival.server.model.Concert;
import dev.blasio99.untoldfestival.server.service.ServiceException;
import dev.blasio99.untoldfestival.server.service.ConcertService;


@CrossOrigin("*")
@RestController
public class ConcertResource {

    @Autowired
    private ConcertService concertService;

    @Autowired
    private ConcertAssembler concertAssembler;

	
    @GetMapping("api/concert/genre/{genre}")
    public ResponseEntity<List<ConcertDTO>> getConcertsByGenre(@PathVariable String genre) {
        try {
            List<ConcertDTO> concerts = concertAssembler.createDTOList(concertService.getConcertsByGenre(genre));
            return new ResponseEntity<>(concerts, HttpStatus.OK);
        }
        catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
 
    }

    @GetMapping("api/concert/performer/{performer}")
    public List<ConcertDTO> getConcertsByPerformer(@PathVariable String performer) {
        return concertAssembler.createDTOList(concertService.getConcertsForPerformer(performer));
    }

    @PostMapping("api/concert/add")
    public Concert addConcert(@RequestBody ConcertDTO dto) {
        return concertService.addConcert(concertAssembler.createModel(dto));
    }

	@GetMapping("api/concert/all")
	public List<ConcertDTO> getConcerts() {
		List<String> genres = EnumSet.allOf(Genres.class).stream().map(e -> e.name()).collect(Collectors.toList());

		List<ConcertDTO> list = new ArrayList<>();
		
		for(String g : genres){
			List<ConcertDTO> validList = concertAssembler.createDTOList(concertService.getConcertsByGenre(g));
			if(!validList.isEmpty())
				list = Stream.concat(list.stream(), validList.stream()).collect(Collectors.toList());
		}
        return list;
    }
	

}

