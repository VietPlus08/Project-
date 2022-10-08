package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Facility {
    String id;
    int period;
    int area, max_person, price;
    int type, floor;
    int pool_area;
    
}
