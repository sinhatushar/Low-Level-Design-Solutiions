import model.*;
import service.*;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        CartService cartService = new CartServiceImpl(productService, userService, orderService);

        User user1 = userService.createUser("usr1", "email1", "passwd1", new Address("city1", "hNo1", "sec1"));
        User user2 = userService.createUser("usr2", "email2", "passwd2", new Address("city2", "hNo2", "sec2"));

        Product product1 = productService.addProduct("pr1", 100, 10);
        Product product2 = productService.addProduct("pr2", 200, 20);
        Product product3 = productService.addProduct("pr3", 300, 30);

        CartItem cartItem1 = cartService.addToCart(user1.getUserId(), product1.getProductId(),1);
        CartItem cartItem2 = cartService.addToCart(user1.getUserId(), product2.getProductId(),2);
        CartItem cartItem3 = cartService.addToCart(user1.getUserId(), product3.getProductId(),3);

        Order order = cartService.checkout(user1.getUserId());

        List<Order> orderHistory = orderService.getOrderHistory(user1.getUserId());

        for(Order orderIter: orderHistory) {
            System.out.println(orderIter);
        }
    }
}
