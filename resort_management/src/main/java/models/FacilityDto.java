package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repositories.impl.FacilityRepositories;

@Getter @Setter @NoArgsConstructor
public class FacilityDto {
    FacilityRepositories repositories = new FacilityRepositories();
    String id;
    int period;
    int area, max_person, price;
    int type, floor;
    int pool_area;
    int times;

    public FacilityDto(Facility facility) {
        id = facility.getId();
        period = facility.getPeriod();
        area = facility.getArea();
        max_person = facility.getMax_person();
        price = facility.getPrice();
        type = facility.getType();
        floor = facility.getFloor();
        pool_area = facility.getPool_area();
        times = repositories.getUsedTimes(id);
    }
}
