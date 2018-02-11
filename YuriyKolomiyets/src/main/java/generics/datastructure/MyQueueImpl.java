package generics.datastructure;

import java.util.Iterator;

public class MyQueueImpl<T> implements MyQueue<T> {


    private T[] mas = (T[]) new Object[20];
    private int head;
    private int tail;
    private int queueSize;


    @Override
    public boolean enqueue(T el) throws NoFreeSpaceException {
        if(queueSize > mas.length){
            throw new NoFreeSpaceException();

        } else {
            mas[tail++] = el;
            queueSize++;
            return true;
        }
    }

    @Override
    public T dequeue() throws NoElementsException {
        if(queueSize == 0){
            throw new NoElementsException();
        }

        T ret = mas[head++];
        queueSize--;
        return ret;
    }




    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayQueueIterator();

    }

    public class MyArrayQueueIterator implements Iterator<T> {

        int current = head;

        @Override
        public boolean hasNext() {
            if(current < queueSize){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T ret = mas[current++];
            return ret;
        }
    }


}
