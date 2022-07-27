package com.tsi.veitch.springbootdemo.actor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    @Query(value = "SELECT actor.* FROM actor INNER JOIN film_actor on actor.actor_id=film_actor.actor_id inner join film on film_actor.film_id=film.film_id AND film.film_id=?1", nativeQuery = true)
    Collection<Actor> returnActorsByID(int id);

}
