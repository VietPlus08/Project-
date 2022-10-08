package repositories.impl;

import models.Customer;
import repositories.IBaseRepositories;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IBaseRepositories<Customer> {
    String findByCondition = "SELECT customers.`id`, customers.`name`, address, dob, phone, gender.name as gender, customertype.name as custype FROM customers inner join gender on customers.genderid = gender.id inner join customertype on customers.cusTypeID = customertype.id where customers.id like concat('%',?,'%')";
    String updateById = "update customers set name = ?, address = ?, dob = ?, phone = ?, genderID = ?, cusTypeID = ? where id = ?";
    String createNew = "insert into customers value (?,?,?,?,?,?,?)";
    String deleteOject="delete from customers where id =?";

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findByCondition(String id) {
        List<Customer> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(findByCondition)){
        st.setString(1,id);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            list.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),
                    rs.getInt(5), rs.getString(6), rs.getString(7)));
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Customer customer) {
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(createNew)){
            st.setString(1,customer.getId());
            st.setString(2,customer.getName());
            st.setString(3,customer.getAddress());
            st.setDate(4,customer.getDob());
            st.setInt(5,customer.getPhone());
            st.setString(6,customer.getGender());
            st.setString(7,customer.getCusType());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(deleteOject)){
            st.setString(1,id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(updateById)){
            st.setString(1,customer.getName());
            st.setString(2,customer.getAddress());
            st.setDate(3,customer.getDob());
            st.setInt(4,customer.getPhone());
            st.setString(5,customer.getGender());
            st.setString(6,customer.getCusType());
            st.setString(7,customer.getId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
