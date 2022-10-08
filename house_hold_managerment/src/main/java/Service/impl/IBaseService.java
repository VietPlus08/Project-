package Service.impl;

import java.util.List;

public interface IBaseService<E> {
    List<E> findAll(int index);

    int countHouseHold();

    E findById(String id);

    void updateHouseHold(E e);
    String findPersonInHouse(String id);
}
