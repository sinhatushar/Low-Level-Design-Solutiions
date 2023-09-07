package service;

import model.Cart;
import model.Order;
import model.User;

import java.util.List;

public interface OrderService {
    List<Order> getOrderHistory(String userId);

    Order createOrder(User user, Cart cart, double totalPrice);
}
