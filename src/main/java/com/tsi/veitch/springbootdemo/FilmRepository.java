package com.tsi.veitch.springbootdemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query(value = "SELECT * FROM film WHERE film_id = ?1", nativeQuery = true) Collection<Film> getFilmFromID(int id);

    @Query(
            value = "SELECT film_id FROM film WHERE title = ?1",
            nativeQuery = true)
    String getIdFromTitle(String title);
}
