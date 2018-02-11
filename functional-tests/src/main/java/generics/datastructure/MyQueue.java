package generics.datastructure;

/**
 * Created by serhii on 11.02.18.
 */
public interface MyQueue<T> extends Iterable<T> {


    boolean queue(T el) throws NoFreeSpaceException;
    T enqueue() throws NoElementsException;
    int size();

}
