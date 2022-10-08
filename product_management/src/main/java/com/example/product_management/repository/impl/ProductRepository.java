package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IBaseRepository;
import com.example.product_management.util.ConnectData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;
public class ProductRepository implements IBaseRepository<Product> {
    String selectAll1 = "select product.name, price, quantity, color, description, category.name from product join category where category = category.id";
    String selectAll = "select product.name, price, quantity, color, description, category.name from product join category where category = category.id order by product.name limit 5 offset ?";
    String selectByName = "select * from product where name = ?";
    String selectSearchByName = "select * from product where name like ? order by name limit 5 offset ?";
    String insertNew = "insert into product value (?,?,?,?,?,?)";
    String update = "update product set price = ?, quantity = ?, color = ?, description = ?, category = ? where name = ?";
    String delete = "delete from product where name = ?";
    String countProductItems = "SELECT count(*) FROM product";
    String countProductItemsBySearchName = "SELECT count(*) FROM product where name like ?";
    @Override
    public List<Product> findAll(int number) {
        List<Product> repository = new ArrayList<>();
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(selectAll)){
            st.setInt(1,number);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                repository.add(new Product(Arrays.asList(rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(1),rs.getString(5),rs.getString(6))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }

    @Override
    public void delete(String name) {
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(delete)){
            st.setString(1,name);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Product product) {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(insertNew)){
            st.setString(1, product.getName());
            st.setInt(2, product.getPrice());
            st.setInt(3, product.getQuantity());
            st.setString(4, product.getColor());
            st.setString(5, product.getDes());
            st.setString(6, product.getCategory());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(update)){
            st.setInt(1, product.getPrice());
            st.setInt(2, product.getQuantity());
            st.setString(3, product.getColor());
            st.setString(4, product.getDes());
            st.setString(5, product.getCategory());
            st.setString(6, product.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Product getObjectByName(String name) {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(selectByName)){
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Product(Arrays.asList(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name, int index) {
        List<Product> repository = new ArrayList<>();
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(selectSearchByName) ){
            st.setString(1,"%" + name + "%");
            st.setInt(2,index);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                repository.add(new Product(Arrays.asList(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(1),rs.getString(5),rs.getString(6))));
            }
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }
    public int countProductItems(){
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(countProductItems)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public int countProductItems(String name){
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(countProductItemsBySearchName)){
            st.setString(1,"%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
