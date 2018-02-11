package generics.datastructure;

import java.util.Iterator;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {


    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        return false;
    }

    @Override
    public T dequeue() throws NoElementsException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
