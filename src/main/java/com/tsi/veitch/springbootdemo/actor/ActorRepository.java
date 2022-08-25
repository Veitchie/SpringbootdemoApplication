package com.tsi.veitch.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    Iterable<Actor> findByActorId(Integer id);

    Iterable<Actor> findByFullNameContainingIgnoreCase(String name);

}
