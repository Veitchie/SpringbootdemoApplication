package com.tsi.veitch.springbootdemo.actor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tsi.veitch.springbootdemo.film.Film;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    @JsonIgnore
    @ManyToMany(mappedBy = "actorSet")
    public Set<Film> films;

    //Attributes
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;

    public Actor(String first_name, String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
    }

    public Actor(int id, String first_name, String last_name){
        this.actor_id = id;
        this.first_name=first_name;
        this.last_name=last_name;
    }

    //Empty Constructor
    public Actor() {}

    //Getter and Setters

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
