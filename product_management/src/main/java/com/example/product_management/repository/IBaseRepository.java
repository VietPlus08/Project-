package com.example.product_management.repository;

import java.util.List;

public interface IBaseRepository<E> {

    List<E> findAll(int number);
    void delete(String name);
    void insert(E e);
    void update(E e);
    E getObjectByName(String name);

    List<E> searchByName(String name,int index);

    int countProductItems();
    int countProductItems(String name);
}
