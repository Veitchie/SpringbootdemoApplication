package com.tsi.veitch.springbootdemo.film;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    Iterable<Film> findByFilmId(int id);

    @Query(
            value = "SELECT film_id FROM film WHERE title = ?1",
            nativeQuery = true)
    String getIdFromTitle(String title);

    @Query(value = "SELECT film.* FROM film INNER JOIN film_actor ON film.film_id=film_actor.film_id INNER JOIN actor ON film_actor.actor_id=actor.actor_id AND actor.actor_id=?1", nativeQuery = true)
    Collection<Film> returnFilmByID(int id);

    @Query(value = "SELECT film.* FROM film INNER JOIN film_category ON film.film_id=film_category.film_id INNER JOIN category ON film_category.category_id=category.category_id AND category.category_id=?1", nativeQuery = true)
    Collection<Film> getFilmFromCat(int id);

    @Query(value = "SELECT count(*) FROM inventory INNER JOIN film ON inventory.film_id=film.film_id AND film.film_id=?1", nativeQuery = true)
    int getStockFromID(int id);

}
