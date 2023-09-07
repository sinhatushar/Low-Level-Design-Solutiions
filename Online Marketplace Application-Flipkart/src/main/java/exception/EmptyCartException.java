package exception;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String userId) {
        super("Cart is empty for userId: " + userId);
    }
}
