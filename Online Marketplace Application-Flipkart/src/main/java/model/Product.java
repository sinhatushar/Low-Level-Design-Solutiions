package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {
    private String productId;
    private String name;
    private double price;
    private int availableQuantity;

    public Product(String name, double price, int availableQuantity) {
        productId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }
}
