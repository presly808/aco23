package generics.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private T[] mas;
    private static final int DEFAULT_QUEUE_CAPACITY = 10;

//    size -- number of added elements to the queue;
//    head -> mas[0]; tail -> mas[size]
    private int size;


    public MyQueueImpl() {
        mas = (T[]) new Object[DEFAULT_QUEUE_CAPACITY];
    }

    public MyQueueImpl(int queueCapacity) throws IllegalArgumentException{
        if(queueCapacity <= 0) throw new IllegalArgumentException();
        mas = (T[]) new Object[queueCapacity];
    }

    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {

        if(size >= mas.length) throw new NoFreeSpaceException();

        mas[size++] = el;

        return true;
    }

    @Override
    public T dequeue() throws NoElementsException {
        if(size == 0) throw new NoElementsException();

        T el = mas[0];

        System.arraycopy(mas, 1, mas, 0, size - 1);
        mas[size] = null;
        size--;

        return el;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private int cursor = -1; // index of next element to return

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() throws NoSuchElementException {
            if(cursor >= size) throw new NoSuchElementException();

            int i = cursor;
            i++;
            return mas[i];
        }
    }
}
