package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private Cart cart;
    private Address address;

    public User(String name, String email, String password, Address address) {
        userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        cart = new Cart(userId);
        this.address = address;
    }
}
