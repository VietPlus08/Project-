package com.example.quan_ly_ho_khau.Service;

import com.example.quan_ly_ho_khau.Model.HouseHoldDto;

import java.util.List;

public interface IBaseService<E> {
    List<E> findAll(int index);

    int getNumberPages();
    List<String > findPersonInHouseHold(String id);

    List<E> searchByName(String name);
    void updateHouseHold(E e);
    E searchById(String id);
}
