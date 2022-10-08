package com.example.flat_management.repository.impl;

import com.example.flat_management.models.Flat;
import com.example.flat_management.repository.IBFlatRepository;
import com.example.flat_management.utils.ConnectData;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class FlatRepository implements IBFlatRepository<Flat> {


    String findall = "select id, area, status_name,stage,type_name,price,date_in,date_out from flat,status,type where status = status_id and type = type_id";

    String searchById = "select id, area, status_name,stage,type_name,price,date_in,date_out from flat,status,type where status = status_id and type = type_id and id like concat('%',?,'%') and status_name like concat('%',?,'%')";

    String createNew = "insert into flat value(?,?,?,?,?,?,?,?)";
    String delete = "delete from flat where id = ?";

    @Override
    public List<Flat> findAll() {
        List<Flat> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(findall)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Flat(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),
                        rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getDate(8)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void delete(String id) {
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(delete)){
            st.setString(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Flat> Search(String id, String status) {
        List<Flat> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(searchById)){
            st.setString(1,id);
            st.setString(2,status);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Flat(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),
                        rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getDate(8)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;}


    @Override
    public void create(Flat flat) {
        try(Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(createNew)){
            st.setString(1,flat.getId());
            st.setInt(2,flat.getArea());
            st.setString(3,flat.getStatus());
            st.setInt(4,flat.getStage());
            st.setString(5,flat.getType());
            st.setInt(6,flat.getPrice());
            st.setDate(7,flat.getDate_in());
            st.setDate(8,flat.getDate_out());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
