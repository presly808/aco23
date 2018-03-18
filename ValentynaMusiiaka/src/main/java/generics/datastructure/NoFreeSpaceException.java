package generics.datastructure;

/**
 * Created by serhii on 11.02.18.
 */
public class NoFreeSpaceException extends Exception {

    public NoFreeSpaceException() {
        super("No free space available in array");
    }
}
