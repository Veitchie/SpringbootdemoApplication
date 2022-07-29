package com.tsi.veitch.springbootdemo;

import com.tsi.veitch.springbootdemo.actor.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class createAnActorStepdefs {

    Actor actor;
    String firstName;
    String lastName;

    @When("I get their firstName and lastName")
    public void getFirstAndLastName(){
        firstName = actor.getFirstName();
        lastName = actor.getLastName();
    }

    @Given("I create an actor and firstName is {string} and lastName is {string}")
    public void iCreateAnActorAndFirstNameIsAndLastNameIs(String arg0, String arg1) {
        actor = new Actor(arg0, arg1);
    }

    @Then("their firstName should be {string} and their lastName should be {string}")
    public void theirFirstNameShouldBeAndTheirLastNameShouldBe(String arg0, String arg1) {
        assertEquals(arg0, firstName);
        assertEquals(arg1, lastName);
    }

    @Given("I create an actor without a firstName or lastName")
    public void iCreateAnActorWithoutAFirstNameOrLastName() {
        actor = new Actor();
    }

    @Then("their firstName and lastName should be null")
    public void theirFirstNameAndLastNameShouldBeNull() {
        assertNull(firstName);
        assertNull(lastName);
    }
}
