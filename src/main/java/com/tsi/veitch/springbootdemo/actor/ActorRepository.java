package com.tsi.veitch.springbootdemo.actor;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    Iterable<Actor> findByActorId(Integer id);
}
