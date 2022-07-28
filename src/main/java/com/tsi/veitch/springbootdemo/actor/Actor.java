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
    private int actorId;

    @JsonIgnore
    @ManyToMany(mappedBy = "actorSet")
    public Set<Film> films;

    //Attributes
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public Actor(ActorDTO actorDTO){
        this.updateFromDTO(actorDTO);
    }

    public Actor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Empty Constructor
    public Actor() {}

    public void updateFromDTO(ActorDTO actorDTO) {
        this.firstName = actorDTO.getFirstName().orElse(firstName);
        this.lastName = actorDTO.getLastName().orElse(lastName);
    }

    public void update(String firstName, String lastName) {
        if (firstName != null){this.firstName = firstName;}
        if (lastName != null){this.lastName = lastName;}
    }

    //Getter and Setters

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
