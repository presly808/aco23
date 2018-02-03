package company.notifier;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MyEventTest {

    private MyEvent event;

    @Before
    public void setUp() {
        event = new MyEvent(new Date(), "place", null);
    }

    @Test
    public void getPlace() {
        assertEquals("place", event.getPlace());
    }

    @Test
    public void setPlace() {
        event.setPlace("place1");
        assertEquals("place1", event.getPlace());
    }
}