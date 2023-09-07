package exception;

public class DuplicateEmailForUserException extends RuntimeException {
    public DuplicateEmailForUserException(String message) {
        super(message);
    }
}
