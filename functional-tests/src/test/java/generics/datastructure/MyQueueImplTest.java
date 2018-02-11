package generics.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyQueueImplTest {

    private MyQueue<String> myQueue;

    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueueImpl<>();
        myQueue.enqueue("Les");
        myQueue.enqueue("Fox");
        myQueue.enqueue("String");
        myQueue.enqueue("");
        myQueue.enqueue("Object");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithSize() {
        myQueue = new MyQueueImpl<>();
    }

    @Test
    public void enqueue() throws Exception {
        myQueue.enqueue("new String");
        assertEquals(6, myQueue.size());
    }

    @Test(expected = NoFreeSpaceException.class)
    public void enqueueException() throws Exception {
        for (int i = 0; i < 1000; i++)
            myQueue.enqueue("new String");
    }

    @Test
    public void dequeue() throws Exception {
        assertEquals("Les", myQueue.dequeue());
        assertEquals("Fox", myQueue.dequeue());
        assertEquals("String", myQueue.dequeue());
    }

    @Test(expected = NoElementsException.class)
    public void dequeueException() throws Exception {
        for (int i = 0; i < 1000; i++)
            myQueue.dequeue();
    }

    @Test
    public void size() throws Exception {
        assertEquals(5, myQueue.size());
        myQueue.dequeue();
        assertEquals(4, myQueue.size());
    }

    @Test
    public void iterator() {
        Iterator<String> itr = myQueue.iterator();
        assertTrue(itr.hasNext());
        assertEquals("Les", itr.next());
    }
}