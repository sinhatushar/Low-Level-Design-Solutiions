package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    private String orderId;
    private User user;
    private OrderStatus orderStatus;
    private List<CartItem> cartItems;
    private double totalPrice;

    public Order(User user, List<CartItem> cartItems, double totalPrice) {
        orderId = UUID.randomUUID().toString();
        this.user = user;
        orderStatus = OrderStatus.CREATED;
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    //TODO: Add order status update function on successful payment
}
