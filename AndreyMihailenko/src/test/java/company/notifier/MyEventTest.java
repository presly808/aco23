package company.notifier;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MyEventTest {

    private MyEvent myEvent;

    @Before
    public void setUp() {
        myEvent = new MyEvent("Some place", "Some info");
    }


    @Test
    public void getPlace() {
        assertEquals("Some place", myEvent.getPlace());
    }

    @Test
    public void setPlace() {
        myEvent.setPlace("change place");
        assertEquals("change place", myEvent.getPlace());
    }

    @Test
    public void getInfo() {
        assertEquals("Some info", myEvent.getInfo());
    }

    @Test
    public void setInfo() {
        myEvent.setInfo("change info");
        assertEquals("change info", myEvent.getInfo());
    }
}