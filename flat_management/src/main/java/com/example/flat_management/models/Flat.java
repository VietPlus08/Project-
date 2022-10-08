package com.example.flat_management.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Flat {
    String id;
    int area;
    String status;
    int stage;
    String type;
    int price;
    Date date_in;
    Date date_out;
}
