package model;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.sql.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseHold {
    String id, name;
    int numPerson;
    Date date;
    String address;
}
