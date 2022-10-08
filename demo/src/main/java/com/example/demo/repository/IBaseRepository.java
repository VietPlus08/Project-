package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IBaseRepository<E> {

    List<Product> findAll();
    void delete(int id);
    void create(Object o);
}
