package exception;

public class ProductNotFoundException extends MarketplaceException {
    public ProductNotFoundException(String productId) {
        super("Product not found for productId: " + productId);
    }
}
