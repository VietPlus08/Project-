package models;

import lombok.*;

import java.sql.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    String id;
    String name, address;
    Date dob;
    int phone;
    String gender, cusType;

}
