import com.tsi.veitch.springbootdemo.actor.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    @Test
    public void test_getActorId(){
        Actor testActor = new Actor();

        testActor.setActorId(666);
        assertEquals(666, testActor.getActorId(), "Returned ID was not correct");
    }

    @Test
    public void test_getFirstName(){
        Actor testActor = new Actor();

        testActor.setFirstName("JOHN");
        assertEquals("JOHN", testActor.getFirstName(), "Returned name was not correct");
    }

    @Test
    public void test_getLastName(){
        Actor testActor = new Actor();

        testActor.setLastName("DOE");
        assertEquals("DOE", testActor.getLastName(), "Returned name was not correct");
    }
}
