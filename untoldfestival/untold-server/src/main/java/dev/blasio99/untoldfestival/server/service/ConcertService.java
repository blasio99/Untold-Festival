package dev.blasio99.untoldfestival.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.blasio99.untoldfestival.server.model.Concert;
import dev.blasio99.untoldfestival.server.repo.ConcertRepository;

@Service
public class ConcertService {
    
    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> getConcertsForPerformer(String performer) {
        return concertRepository.findByPerformer(performer);
    }

    public List<Concert> getConcertsByGenre(String genre) throws ServiceException {
        String genreUppercase;
        try {
            genreUppercase = genre.toUpperCase();
        } catch(IllegalArgumentException e) {
            throw new ServiceException("Illegal argument!", HttpStatus.BAD_REQUEST);
        }
        return concertRepository.findByGenre(genreUppercase);
    }

	// public List<Concert> getConcertsByGenre(List<String> genre) throws ServiceException {
    //     List<Concert> allConcerts = new ArrayList<>();
		
    //     return allConcerts;
    // }

    public Concert addConcert(Concert concert) {
		System.out.println("  ----------------- " + concert.getStartDate());
        return concertRepository.save(concert);
    }
}