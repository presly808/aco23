package generics.datastructure;

import java.util.Iterator;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {
    @Override
    public boolean queue(T el) throws NoFreeSpaceException {
        System.out.println();

        return false;


    }


    @Override
    public T enqueue() throws NoElementsException {
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

