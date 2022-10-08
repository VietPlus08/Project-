package com.example.quan_ly_ho_khau.Model;

import com.example.quan_ly_ho_khau.Repository.impl.HouseHoldRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseHoldDto {
    HouseHoldRepository houseHoldRepository = new HouseHoldRepository();
    String id;
    String name;
    int numPerson;
    Date date;
    String address;
    String listPersonInHouse;

    public HouseHoldDto(HouseHold houseHold) {
        this.id = houseHold.getId();
        this.name = houseHold.getName();
        this.numPerson = houseHold.getNumPerson();
        this.date = houseHold.getDate();
        this.address = houseHold.getAddress();
        this.listPersonInHouse = houseHoldRepository.findPersonInHouseHold(houseHold.getId());
    }
}
