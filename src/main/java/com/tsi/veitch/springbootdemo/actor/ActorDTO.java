package com.tsi.veitch.springbootdemo.actor;

import java.util.Optional;

public class ActorDTO {

    private String firstName;
    private String lastName;

    public ActorDTO(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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
