package service;

import model.Product;

public interface ProductService {
    Product getProduct(String productId);

    Product addProduct(String name, double price, int availableQuantity);

    boolean checkProductAvailability(String productId, int quantity);
}
