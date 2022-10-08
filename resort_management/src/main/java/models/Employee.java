package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Employee {
    String id, name, address;
    Date dob;
    int phone;
    int gender;
    int degree, position;
    int salary;
}
