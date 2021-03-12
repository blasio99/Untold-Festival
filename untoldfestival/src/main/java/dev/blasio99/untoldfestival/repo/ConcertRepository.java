package dev.blasio99.untoldfestival.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.godraadam.untold.model.Concert;
import dev.godraadam.untold.model.Genre;

public interface ConcertRepository extends CrudRepository<Concert, Long> {
    public List<Concert> findByPerformer(String performer);
    public List<Concert> findByGenre(String genre);
}