package com.tsi.veitch.springbootdemo.actor;

import com.tsi.veitch.springbootdemo.film.Film;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    Iterable<Actor> findByActorId(Integer id);

//    @Modifying
//    @Query(value = "INSERT INTO film_actor (actor_id, film_id) VALUES (actorId, filmId)", nativeQuery = true)
//    void updateRoll(@Param("actorId") int actor_id, @Param("filmId") int film_id);
}
