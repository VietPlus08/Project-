package Service.impl;

import model.HouseHoldDto;
import repository.impl.HouseHoldRepository;

import java.util.List;

public class HouseHoldService implements IBaseService<HouseHoldDto> {
    HouseHoldRepository houseHoldRepository = new HouseHoldRepository();
    @Override
    public List<HouseHoldDto> findAll(int index) {
        index = (index - 1) * 5;
        return houseHoldRepository.findAll(index);
    }

    @Override
    public int countHouseHold() {
        int numberHouse = houseHoldRepository.countHouseHold();
        return numberHouse%5 == 0 ? numberHouse/5 : numberHouse/5 + 1;
    }

    @Override
    public HouseHoldDto findById(String id) {
        return houseHoldRepository.findById(id);
    }

    @Override
    public void updateHouseHold(HouseHoldDto houseHoldDto) {
        houseHoldRepository.update(houseHoldDto);
    }

    @Override
    public String findPersonInHouse(String id) {
        return houseHoldRepository.findPersonInHouse(id);
    }
}
