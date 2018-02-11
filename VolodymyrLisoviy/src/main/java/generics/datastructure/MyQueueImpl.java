package generics.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public MyQueueImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if (size == elements.length)
            throw new NoFreeSpaceException();

        elements[size++] = el;

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() throws NoElementsException {
        if (size == 0)
            throw new NoElementsException();
        T toRet = (T) elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        return toRet;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (index >= size) {
                throw new NoSuchElementException();
            }
            return (T) elements[index++];
        }
    }
}
