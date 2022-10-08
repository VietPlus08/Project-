package utils;

import models.Customer;
import models.Employee;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Valid {
    public static Map<String,String> getValidation(Customer customer){
        Map<String,String> error = new HashMap<>();
        if (!customer.getId().matches("[A-Z]{2,2}[0-9]{4,4}")){
            error.put("id","Must contains 2 characters and 4 numbers");
        }
        if (!customer.getName().matches("([A-Z]{1}[a-z]+[\\s]*)+")){
            error.put("name","Must be characters, the firt character in letters must be upper");
        }
        if (!customer.getAddress().matches("([\\w|\\s]+)")){
            error.put("address","Must be word");
        }
        if (!customer.getDob().before(Date.valueOf("2020-01-01"))){
            error.put("dob", "Must be before 2020-01-01");
        }
        return error;
    }
    public static Map<String,String> getValidation(Employee employee){
        Map<String,String> error = new HashMap<>();
        if (!employee.getId().matches("[A-Z]{2,2}[0-9]{4,4}")){
            error.put("id","Must contains 2 characters and 4 numbers");
        }
        if (!employee.getName().matches("([A-Z]{1}[a-z]+[\\s]*)+")){
            error.put("name","Must be characters, the firt character in letters must be upper");
        }
        if (!employee.getAddress().matches("([\\w|\\s]+)")){
            error.put("address","Must be word");
        }
        if (!employee.getDob().before(Date.valueOf("2020-01-01"))){
            error.put("dob", "Must be before 2020-01-01");
        }
        return error;
    }
}
