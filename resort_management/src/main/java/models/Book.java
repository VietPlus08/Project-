package models;

import lombok.*;

import java.sql.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    String id;
    String customer_name;
    String facility_name;
    int companion;
    Date date_in, date_out;
}
