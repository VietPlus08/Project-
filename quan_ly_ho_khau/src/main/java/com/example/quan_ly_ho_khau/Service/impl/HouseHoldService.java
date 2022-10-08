package com.example.quan_ly_ho_khau.Service.impl;

import com.example.quan_ly_ho_khau.Model.HouseHold;
import com.example.quan_ly_ho_khau.Model.HouseHoldDto;
import com.example.quan_ly_ho_khau.Repository.impl.HouseHoldRepository;
import com.example.quan_ly_ho_khau.Service.IBaseService;

import java.util.List;

public class HouseHoldService implements IBaseService<HouseHoldDto> {
    HouseHoldRepository houseHoldRepository = new HouseHoldRepository();

    @Override
    public List<HouseHoldDto> findAll(int index) {
        int offset = (index -1 ) * 5;
        return houseHoldRepository.findAll(offset);
    }

    @Override
    public int getNumberPages() {
        int allHouseHold = houseHoldRepository.countHouseHoldFromDatabase();
        return allHouseHold % 5 == 0 ? allHouseHold / 5 : allHouseHold / 5 + 1;

    }

    @Override
    public List<String> findPersonInHouseHold(String id) {
        return null;
    }

    @Override
    public List<HouseHoldDto> searchByName(String name) {
        return houseHoldRepository.searchByName(name);
    }

    @Override
    public void updateHouseHold(HouseHoldDto houseHoldDto) {
        houseHoldRepository.updateHouseHold(houseHoldDto);
    }

    @Override
    public HouseHoldDto searchById(String id) {
        return houseHoldRepository.searchById(id);
    }
}
