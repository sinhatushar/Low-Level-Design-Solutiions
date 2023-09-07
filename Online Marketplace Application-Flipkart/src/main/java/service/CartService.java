package service;

import model.CartItem;
import model.Order;

import java.util.List;

public interface CartService {
    List<CartItem> getCart(String userId);

    CartItem addToCart(String userId, String productId, int quantity);

    Order checkout(String userId);
}

