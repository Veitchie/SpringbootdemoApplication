package com.tsi.veitch.springbootdemo.actor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

}
