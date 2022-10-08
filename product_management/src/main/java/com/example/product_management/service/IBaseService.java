package com.example.product_management.service;

import java.util.List;
import java.util.Map;

public interface IBaseService<E> {
    List<E> findAll();
    List<E> findItemForCurrentPage(int index);
    Map<String,String> registry (E e);
    E getObjectByName(String name);
    void deleteOject(String name);
    List<E> searchByName(String name,int index);
    int getNumberPage();
    int getNumberPage(String name);
}
