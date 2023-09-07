package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private List<CartItem> cartContents;
    private String userId;

    public Cart(String userId) {
        cartContents = new ArrayList<>();
        this.userId = userId;
    }

    public List<CartItem> addProduct(CartItem cartItem) {
        cartContents.add(cartItem);
        return cartContents;
    }
}
