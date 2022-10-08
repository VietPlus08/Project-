package com.example.flat_management.repository;

import java.util.List;

public interface IBFlatRepository<E> {
    List<E> findAll();
    void delete(String id);
    List<E> Search(String id, String status);
    void create (E e);
}
