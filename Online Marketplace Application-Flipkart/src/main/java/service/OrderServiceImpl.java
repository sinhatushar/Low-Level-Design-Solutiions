package service;

import model.Cart;
import model.Order;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrderHistory(String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUser().getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    @Override
    public Order createOrder(User user, Cart cart, double totalPrice) {
        Order order = new Order(user, cart.getCartContents(), totalPrice);
        orders.add(order);
        return order;
    }
}
