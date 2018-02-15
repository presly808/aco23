package generics.datastructure;

import java.util.Iterator;


/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private T [] mas = (T[]) new Object[10];
    private int head;
    private int tail;
    private int size;

    public MyQueueImpl() {
    }

    public MyQueueImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        mas = (T[]) new Object[size];
    }

    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if (size >= mas.length){
            throw new NoFreeSpaceException();
        }
        mas[tail++] = el;
        size++;
        return false;
    }

    @Override
    public T dequeue() throws NoElementsException {
        if (size == 0) {
            throw new NoElementsException();
        }
        T ret = mas[head++];
        size--;
        return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyQuenueIterator<>();
    }

    private class MyQuenueIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return head < tail;
        }

        @Override
        public T next() {
            T obj = (T) mas[head++];
            return obj;
        }
    }
}
