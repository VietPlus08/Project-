package com.example.quan_ly_ho_khau.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HouseHold {
    String id;
    String name;
    int numPerson;
    Date date;
    String address;
}
