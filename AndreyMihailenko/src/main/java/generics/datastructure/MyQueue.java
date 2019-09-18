package generics.datastructure;

public interface MyQueue<T> extends Iterable<T> {


    boolean enqueue(T el) throws NoFreeSpaceException;
    T dequeue() throws NoElementsException;
    int size();

}
