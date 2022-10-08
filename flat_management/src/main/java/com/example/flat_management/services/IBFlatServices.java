package com.example.flat_management.services;

import java.util.List;
import java.util.Map;

public interface IBFlatServices<E> {
    List<E> findAll();
    void delete(String id);
    List<E> Search(String id, String status);
    Map<String,String> create (E e);
    E findById(String id, String status);
}
