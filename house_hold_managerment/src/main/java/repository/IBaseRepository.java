package repository;

import model.HouseHoldDto;

import java.util.List;

public interface IBaseRepository<E> {
    List<E> findAll(int offset);

    int countHouseHold();

    E findById(String id);
    void update (E e);
    String findPersonInHouse(String id);

}
