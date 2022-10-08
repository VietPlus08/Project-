package com.example.flat_management.utils;

import com.example.flat_management.models.Flat;

import java.util.HashMap;
import java.util.Map;

public class Valid {
    public Map<String,String> getValidation(Flat flat){
        Map<String,String> map = new HashMap<>();
        if (!flat.getId().matches("[A-Z]{2}[0-9]{3}")){
            map.put("id","1st, 2nd digits are word; 3rd to 6th are number");
        }
        if (flat.getArea() < 20){
            map.put("area","Must be higher than 20");
        }
        if (flat.getPrice()<100){
            map.put("price", "Must be higher than 100");
        }
        if (!flat.getDate_in().before(flat.getDate_out())){
            map.put("date", "date in < date out");
        }
        return map;
    }
}
