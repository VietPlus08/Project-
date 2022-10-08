package repositories.impl;

import models.Facility;
import repositories.IBaseRepositories;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepositories implements IBaseRepositories<Facility> {
    String findAll = "select * from facility";
    String findByCondition = "select * from facility where facility.id like concat('%',?,'%')";
    String updateById = "update facility set name = ?, address = ?, period = ?, area = ?, max_person = ?, price = ?, type = ?, floor = ? where id = ?";
    String createNew = "insert into facility value (?,?,?,?,?,?,?,?)";
    String deleteOject="delete from facility where id =?";

    @Override
    public List<Facility> findByCondition(String id) {
        List<Facility> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(findByCondition)){
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                list.add(new Facility(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Facility> findAll() {
        List<Facility> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(findAll)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                list.add(new Facility(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Facility facility) {
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(createNew)){
            st.setString(1,facility.getId());
            st.setInt(2,facility.getPeriod());
            st.setInt(3,facility.getArea());
            st.setInt(4,facility.getMax_person());
            st.setInt(5,facility.getPrice());
            st.setInt(6,facility.getType());
            st.setInt(7,facility.getFloor());
            st.setInt(8,facility.getPool_area());
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
    public void update(Facility facility) {
        try(Connection con = ConnectData.getConnect();
            PreparedStatement st = con.prepareStatement(updateById)){
            st.setInt(1,facility.getPeriod());
            st.setInt(2,facility.getArea());
            st.setInt(3,facility.getMax_person());
            st.setInt(4,facility.getPrice());
            st.setInt(5,facility.getType());
            st.setInt(6,facility.getFloor());
            st.setInt(7,facility.getPool_area());
            st.setString(8,facility.getId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
