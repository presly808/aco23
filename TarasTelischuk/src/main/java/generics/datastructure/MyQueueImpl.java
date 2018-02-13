package generics.datastructure;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.Iterator;

/**
 * Created by serhii on 11.02.18.
 */
public class MyQueueImpl<T> implements MyQueue<T> {

    private T [] mas = (T[]) new Object[1000];
    private int head;
    private int tail;
    private int size;


    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if (size > mas.length){
            throw new NoFreeSpaceException();
        }
        mas[tail] = el;
        size++;
        return false;
    }

    @Override
    public T dequeue() throws NoElementsException {
        if (size == 0) {
            throw new NoElementsException();
        }
        T ret = mas[head];
        head++;
        size--;
        return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
