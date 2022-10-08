package com.example.product_management.util;

import com.example.product_management.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Valid {
    public Map<String, String> getValidation(Product product){
        Map<String,String> map = new HashMap<>();
        if (!product.getName().matches("([A-Z0-9](\\w|\\.|_| )+)+")){
            map.put("name","Must be word, first letter in word is uppercase");
        }
        if (product.getPrice()<0){
            map.put("price","Must be positive");
        }
        if (product.getQuantity()<0){
            map.put("quantity","Must be positive");
        }
        if (!product.getCategory().matches("[1234]")){
            map.put("category","Please choose your choice!");
        }
        return map;
    }
}
