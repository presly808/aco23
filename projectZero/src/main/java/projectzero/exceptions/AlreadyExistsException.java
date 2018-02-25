package projectzero.exceptions;

// todo create ApplicationException as parent ex in you program
public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
