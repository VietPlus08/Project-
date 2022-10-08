package com.example.product_management.model;

import java.util.List;

public class Product {
    int price, quantity;
    String name, des, color, category;

    public Product(List<String> data) {
        name = data.get(0);
        price = Integer.parseInt(data.get(1));
        quantity = Integer.parseInt(data.get(2));
        color = data.get(3);
        des = data.get(4);
        category = data.get(5);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }
}
