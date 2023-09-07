package exception;

public class NoOrderHistoryException extends RuntimeException {
    public NoOrderHistoryException(String message) {
        super(message);
    }
}
