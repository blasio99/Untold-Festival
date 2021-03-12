package dev.blasio99.untoldfestival.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.untoldfestival.model.Concert;

public interface ConcertRepository extends CrudRepository<Concert, Long> {
    public List<Concert> findByPerformer(String performer);
    public List<Concert> findByGenre(String genre);
}