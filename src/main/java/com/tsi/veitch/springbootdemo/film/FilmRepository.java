package com.tsi.veitch.springbootdemo.film;

import com.tsi.veitch.springbootdemo.actor.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query(value = "SELECT * FROM film WHERE film_id = ?1", nativeQuery = true) Collection<Film> getFilmFromID(int id);

    @Query(
            value = "SELECT film_id FROM film WHERE title = ?1",
            nativeQuery = true)
    String getIdFromTitle(String title);

    @Query(value = "SELECT actor.* FROM actor INNER JOIN film_actor on actor.actor_id=film_actor.actor_id inner join film on film_actor.film_id=film.film_id AND film.film_id=?1", nativeQuery = true) Collection<Actor> returnActorsByID(int id);
    //actor.actor_id AS actor_id, actor.first_name AS first_name, actor.last_name AS last_name
}
