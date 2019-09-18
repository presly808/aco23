package generics.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyQueueImplTest1 {

    private  MyQueue<String> queueStr = new MyQueueImpl();
    private  MyQueue<Integer> queueInt = new MyQueueImpl();

    @Before
    public void setUp() throws NoFreeSpaceException {
        queueStr.enqueue("Yura");
        queueStr.enqueue("Vova");
        queueStr.enqueue("Taras");

        queueInt.enqueue(56);
        queueInt.enqueue(456);
        queueInt.enqueue(345);
    }

    @Test
    public void enqueueStr() throws NoFreeSpaceException {
        queueStr.enqueue("String");
        queueStr.enqueue("Object");
        assertEquals(5, queueStr.size());
    }

    @Test
    public void dequeueStr() throws NoElementsException {
        queueStr.dequeue();
        assertEquals(2, queueStr.size());
    }

    @Test (expected = NoElementsException.class)
    public void exception1() throws NoElementsException {
        MyQueue<String> queue = new MyQueueImpl<>();
        queue.dequeue();
    }

    @Test
    public void enqueueInt() throws NoFreeSpaceException {
        queueInt.enqueue(56);
        assertEquals(4, queueInt.size());
    }

    @Test
    public void dequeueInt() throws NoElementsException {
        queueInt.dequeue();
        assertEquals(2, queueInt.size());
    }

    @Test
    public void sizeStr() throws NoElementsException {
        assertEquals(3, queueStr.size());
        queueStr.dequeue();
        assertEquals(2, queueStr.size());
    }

    @Test
    public void sizeInt() throws NoFreeSpaceException {
        assertEquals(3, queueInt.size());
        queueInt.enqueue(67);
        assertEquals(4, queueInt.size());
    }

    @Test
    public void iterator(){
        Iterator<String> iterator = queueStr.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Yura", iterator.next());
    }
}