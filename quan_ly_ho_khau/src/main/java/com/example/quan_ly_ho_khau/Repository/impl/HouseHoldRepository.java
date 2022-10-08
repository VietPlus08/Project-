package com.example.quan_ly_ho_khau.Repository.impl;

import com.example.quan_ly_ho_khau.Model.HouseHold;
import com.example.quan_ly_ho_khau.Model.HouseHoldDto;
import com.example.quan_ly_ho_khau.Repository.IBaseRepository;
import com.example.quan_ly_ho_khau.Util.ConnectData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseHoldRepository implements IBaseRepository<HouseHoldDto> {
    String selectHouseHouldList = "select id, house_hold.name, count(person.name) as numPerson, date, address " +
            "from house_hold, person where id = idHH group by id order by id limit 5 offset ?";
    String countHouseHouldItems = "select count(id) from house_hold";
    String findPersonInHouseHold = "select name from person where idHH = ?";
    String searchByName = "select id, house_hold.name, count(person.name) as numPerson, date, address  from house_hold, person where id = idHH and house_hold.name like concat('%',?,'%') group by id";
    String updateHouseHold = "update house_hold set name = ?, date = ?, address = ? where id = ?";
    String searchById = "select id, house_hold.name, count(person.name) as numPerson, date, address from house_hold, person where id = idHH and id = ?";
    @Override
    public List<HouseHoldDto> findAll(int offset) {
        List<HouseHoldDto> list = new ArrayList<>();
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(selectHouseHouldList)) {
            st.setInt(1, offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new HouseHoldDto(new HouseHold(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public int countHouseHoldFromDatabase() {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(countHouseHouldItems)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public String findPersonInHouseHold(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(findPersonInHouseHold)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                stringBuilder.append(rs.getString(1)).append("<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    @Override
    public List<HouseHoldDto> searchByName(String name) {
        List<HouseHoldDto> list = new ArrayList<>();
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(searchByName)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new HouseHoldDto(new HouseHold(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updateHouseHold(HouseHoldDto houseHold) {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(updateHouseHold)) {
            st.setString(1, houseHold.getName());
            st.setString(2, String.valueOf(houseHold.getDate()));
            st.setString(3, houseHold.getAddress());
            st.setString(4, houseHold.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HouseHoldDto searchById(String id) {
        try (Connection con = ConnectData.getConnect(); PreparedStatement st = con.prepareStatement(searchById)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (new HouseHoldDto(new HouseHold(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
