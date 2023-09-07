package service;

import exception.EmptyCartException;
import model.*;

import java.util.*;

public class CartServiceImpl implements CartService {
    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;

    public CartServiceImpl(ProductService productService, UserService userService, OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public List<CartItem> getCart(String userId) {
        return userService.getUser(userId).getCart().getCartContents();
    }

    @Override
    public CartItem addToCart(String userId, String productId, int quantity) {
        Product product = productService.getProduct(productId);

        productService.checkProductAvailability(productId, quantity); // Exception will be thrown

        Cart userCart = userService.getUser(userId).getCart();
        // userCart.getCartContents(); //

        CartItem cartItem = new CartItem(product, quantity);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        userCart.addProduct(cartItem);

        return cartItem;
    }

    @Override
    public Order checkout(String userId) {
        User user = userService.getUser(userId);
        Cart cart = user.getCart();

        if (cart.getCartContents().isEmpty()) {
            throw new EmptyCartException(userId);
        }

        // Check product availability again.
        for (CartItem item : cart.getCartContents()) {
            Product product = item.getProduct();
            productService.checkProductAvailability(product.getProductId(), item.getQuantity()); // Exception will be thrown
        }

        // Reduce product quantities and update availability
        for (CartItem item : cart.getCartContents()) {
            Product product = item.getProduct();
            product.setAvailableQuantity(product.getAvailableQuantity() - item.getQuantity());
        }

        // Calculate total price
        double totalPrice = 0.0;
        for (CartItem item : cart.getCartContents()) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }

        Order order = orderService.createOrder(user, cart, totalPrice);

        // Clear the cart
        cart.getCartContents().clear();

        return order;
    }
}
