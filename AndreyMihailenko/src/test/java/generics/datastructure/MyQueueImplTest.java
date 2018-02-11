package generics.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyQueueImplTest {

    private MyQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new MyQueueImpl<>();
        queue.enqueue("Les");
        queue.enqueue("Fox");
    }

    @Test
    public void enqueue() throws Exception {
        queue.enqueue("new String");
        assertEquals(3, queue.size());
    }


    @Test
    public void dequeue() throws Exception {
        assertEquals("Les", queue.dequeue());
        assertEquals("Fox", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test(expected = NoElementsException.class)
    public void dequeueException() throws Exception {
        for (int i = 0; i < 1000; i++)
            queue.dequeue();
    }

    @Test
    public void size() throws Exception {
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void iterator() {
        Iterator<String> itr = queue.iterator();
        assertTrue(itr.hasNext());
        assertEquals("Les", itr.next());
    }
}