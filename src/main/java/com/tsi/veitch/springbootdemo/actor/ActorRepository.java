package com.tsi.veitch.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    Iterable<Actor> findByActorId(Integer id);

//    @Modifying
//    @Query(value = "INSERT INTO film_actor (actor_id, film_id) VALUES (actorId, filmId)", nativeQuery = true)
//    void updateRoll(@Param("actorId") int actor_id, @Param("filmId") int film_id);
}
