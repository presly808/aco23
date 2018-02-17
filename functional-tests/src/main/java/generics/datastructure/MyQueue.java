package generics.datastructure;

/**
 * Created by serhii on 11.02.18.
 */
public interface MyQueue<T> extends Iterable<T> {


    boolean enqueue(T el) throws NoFreeSpaceException;
    T dequeue() throws NoElementsException;
    int size();

}
