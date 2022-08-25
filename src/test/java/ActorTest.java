import com.tsi.veitch.springbootdemo.actor.Actor;
import com.tsi.veitch.springbootdemo.actor.ActorDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

    @Test
    void test_getActorId(){
        Actor testActor = new Actor();

        testActor.setActorId(666);
        assertEquals(666, testActor.getActorId(), "Returned ID was not correct");
    }

    @Test
    void test_getFirstName(){
        Actor testActor = new Actor();

        testActor.setFirstName("JOHN");
        assertEquals("JOHN", testActor.getFirstName(), "Returned name was not correct");
    }

    @Test
    void test_getLastName(){
        Actor testActor = new Actor();

        testActor.setLastName("DOE");
        assertEquals("DOE", testActor.getLastName(), "Returned name was not correct");
    }

    @Test
    void test_ActorDTO(){
        Actor testActor = new Actor(new ActorDTO("John", "Doe"));

        assertEquals("John", testActor.getFirstName(), "Returned name was not correct");
        assertEquals("Doe", testActor.getLastName(), "Returned name was not correct");
    }

    @Test
    void test_Actor(){
        Actor testActor = new Actor("John", "Doe");

        assertEquals("John", testActor.getFirstName(), "Returned name was not correct");
        assertEquals("Doe", testActor.getLastName(), "Returned name was not correct");
    }

    @Test
    void test_Update(){
        Actor testActor = new Actor("John", "Doe");

        assertEquals("John", testActor.getFirstName(), "Returned name was not correct");
        assertEquals("Doe", testActor.getLastName(), "Returned name was not correct");

        testActor.update("Jane", "Doe");
        assertEquals("Jane", testActor.getFirstName(), "Returned name was not correct");
        assertEquals("Doe", testActor.getLastName(), "Returned name was not correct");
    }
}
