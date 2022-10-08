package com.example.demo.repository.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IBaseRepository;
import com.example.demo.util.ConnectData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;
public class ProductRepository implements IBaseRepository<Product> {
    String selectall = "select * from product";
    @Override
    public List<Product> findAll() {
        List<Product> reprository = new ArrayList<>();
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(selectall) ){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                reprository.add(new Product(Arrays.asList(rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(1),rs.getString(5),rs.getString(6))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reprository;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Object o) {

    }
}
