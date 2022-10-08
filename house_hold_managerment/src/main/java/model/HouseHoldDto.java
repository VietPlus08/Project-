package model;

import Service.impl.HouseHoldService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.impl.HouseHoldRepository;

import java.sql.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseHoldDto {
    HouseHoldRepository repository = new HouseHoldRepository();
    String id, name;
    int numPerson;
    Date date;
    String address;
    String listPersonInHouse;

    public HouseHoldDto(HouseHold houseHold) {
        id = houseHold.getId();
        name = houseHold.getName();
        address = houseHold.getAddress();
        numPerson = houseHold.getNumPerson();
        date = houseHold.getDate();
        listPersonInHouse = repository.findPersonInHouse(houseHold.getId());
    }
}
