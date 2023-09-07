package service;

import exception.InsufficientQuantityException;
import exception.ProductNotFoundException;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private final Map<String, Product> products = new HashMap<>();

//   TODO: private Map<String, Product> products = new ConcurrentHashMap<>();

    @Override
    public Product getProduct(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        return product;
    }

    @Override
    public Product addProduct(String name, double price, int availableQuantity) {
        Product product = new Product(name, price, availableQuantity);
        products.put(product.getProductId(), product);
        return product;
    }

    @Override
    public synchronized boolean checkProductAvailability(String productId, int quantity) {
        Product product = getProduct(productId);
        if (product.getAvailableQuantity() < quantity) {
            throw new InsufficientQuantityException(productId);
        }
        return true;
    }
}
