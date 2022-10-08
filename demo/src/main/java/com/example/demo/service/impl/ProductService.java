package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IBaseRepository;
import com.example.demo.repository.impl.ProductRepository;
import com.example.demo.service.IBaseService;

public class ProductService implements IBaseService<Product> {
    IBaseRepository<Product> productReprository = new ProductRepository();
}
