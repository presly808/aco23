package company.notifier;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MyEventTest {

    @Test
    public void getDate() {
        MyEvent myEvent = new MyEvent(new Date(), "test", "test");
        assertEquals(myEvent.getDate(), myEvent.getDate());
    }

    @Test
    public void setDate() {
        MyEvent myEvent = new MyEvent();
        myEvent.setDate(new Date());
        assertEquals(myEvent.getDate(), myEvent.getDate());
    }

    @Test
    public void getPlace() {
        MyEvent myEvent = new MyEvent(new Date(), "test", "test");
        assertEquals("test", myEvent.getPlace());
    }
}