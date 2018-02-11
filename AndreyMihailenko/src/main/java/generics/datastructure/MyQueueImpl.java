package generics.datastructure;

import java.util.Iterator;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private T[] mas = (T[]) new Object[10];
    private int tail;
    private int head;
    private int size;


    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if (size > mas.length){
            throw new NoFreeSpaceException();
        }
        mas[tail++] = el;
        size++;
        return false;
    }

    @Override
    public T dequeue() throws NoElementsException {
        if (size == 0){
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
        return new MyArrayQueueIterator<>();
    }

    private class MyArrayQueueIterator<T> implements Iterator<T>{

        int curr = head;

        @Override
        public boolean hasNext() {
            return curr < tail;
        }

        @Override
        public T next() {
            T ret = (T) mas[curr++];
            return ret;
        }
    }

}
