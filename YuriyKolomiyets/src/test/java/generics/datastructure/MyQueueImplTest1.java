package generics.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MyQueueImplTest1 {



    @Test
    public void enqueue() throws NoFreeSpaceException {

        MyQueue queue = new MyQueueImpl();

        assertTrue(queue.enqueue("1231"));
        assertTrue(queue.enqueue("34"));
        assertTrue(queue.enqueue("2"));
        assertEquals(queue.size(), 3);
    }

    @Test
    public void dequeue() throws NoFreeSpaceException, NoElementsException {

        MyQueue queue = new MyQueueImpl();

        queue.enqueue("1231");
        queue.enqueue("34");
        queue.enqueue("2");
        queue.dequeue();
        assertEquals(queue.size(), 2);
    }

    @Test
    public void size() throws NoFreeSpaceException {
        MyQueue queue = new MyQueueImpl();

        queue.enqueue("1231");
        assertTrue(queue.enqueue("34"));
        assertEquals(queue.size(), 2);

    }

    @Test
    public void iterator() throws NoFreeSpaceException {
        MyQueue queue = new MyQueueImpl();
        queue.enqueue("1231");
        queue.enqueue("34");
        queue.enqueue("2");

        Iterator<String> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("1231", iterator.next());
    }
}