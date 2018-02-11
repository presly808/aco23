package generics.datastructure;

import java.util.Iterator;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private T[] mas = (T[]) new Object[10];
    private int head;
    private int tail;
    private int size;

    public MyQueueImpl() {
    }

    public MyQueueImpl(T[] mas, int head, int tail, int size) {
        this.mas = mas;
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if (size >= mas.length) {
            throw new NoFreeSpaceException();
        }
        mas[tail++] = el;
        size++;
        return true;
    }

    @Override
    public T dequeue() throws NoElementsException {
        if(size <= 0){
            throw  new NoElementsException();
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
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<T> {

        int curr = head;

        @Override
        public boolean hasNext() {
            return curr < tail;
        }

        @Override
        public T next() {
            T ret = mas[curr++];
            return ret;
        }
    }


}
