package com.example.quan_ly_ho_khau.Repository;

import com.example.quan_ly_ho_khau.Model.HouseHold;
import com.example.quan_ly_ho_khau.Model.HouseHoldDto;

import java.util.List;

public interface IBaseRepository<E> {
    List<E> findAll(int offset);

    int countHouseHoldFromDatabase();
    String findPersonInHouseHold(String id);

    List<E> searchByName(String name);

    void updateHouseHold(E e);

    E searchById(String id);
}
