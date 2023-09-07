package exception;

public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String productId) {
        super("Insufficient quantity available for product: " + productId);
    }
}
