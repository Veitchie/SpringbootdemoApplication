import com.tsi.veitch.springbootdemo.actor.ActorDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorDTOTest {

    @Test
    void test_getFirstName(){
        ActorDTO testActor = new ActorDTO("John", "Doe");

        assertEquals("John", testActor.getFirstName(), "Returned name was not correct");
    }

    @Test
    void test_getLastName(){
        ActorDTO testActor = new ActorDTO("John", "Doe");

        assertEquals("Doe", testActor.getLastName(), "Returned name was not correct");
    }

    @Test
    void test_setFirstName(){
        ActorDTO testActor = new ActorDTO("Jane", "Doe");

        testActor.setFirstName("JOHN");
        assertEquals("JOHN", testActor.getFirstName(), "Returned name was not correct");
    }

    @Test
    void test_setLastName(){
        ActorDTO testActor = new ActorDTO("John", "Boe");

        testActor.setLastName("DOE");
        assertEquals("DOE", testActor.getLastName(), "Returned name was not correct");
    }
}
