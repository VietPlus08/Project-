package repository.impl;

import Utils.ConnectData;
import model.HouseHold;
import model.HouseHoldDto;
import repository.IBaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class HouseHoldRepository implements IBaseRepository<HouseHoldDto> {
    String findAll = "select id, house_hold.name, count(person.name) as numPerson, date, address from house_hold, person where id = idHH group by id order by id limit 5 offset ?";
    String countHouseHold = "Select count(*) from house_hold";

    String findById = "select id, house_hold.name, count(person.name) as numPerson, date, address from house_hold, person where id = idHH and id = ?";
    String updateById = "update house_hold set name = ?, date = ?, address = ? where id = ?";
    String findPersonInHouse = "Select name from person where idHH = ?";
    @Override
    public List<HouseHoldDto> findAll(int offset) {
        List<HouseHoldDto> list = new ArrayList<>();
        try(Connection con = ConnectData.getConnection(); PreparedStatement st = con.prepareStatement(findAll)){
            st.setInt(1,offset);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                list.add(new HouseHoldDto(new HouseHold(rs.getString(1),rs.getString(2),
                        rs.getInt(3),rs.getDate(4),rs.getString(5))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public int countHouseHold() {
        try(Connection con = ConnectData.getConnection(); PreparedStatement st = con.prepareStatement(countHouseHold)){
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public HouseHoldDto findById(String id) {
        try(Connection con = ConnectData.getConnection(); PreparedStatement st = con.prepareStatement(findById)){
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return new HouseHoldDto(new HouseHold(rs.getString(1),rs.getString(2),rs.getInt(3),
                        rs.getDate(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(HouseHoldDto houseHoldDto) {
        try(Connection con = ConnectData.getConnection(); PreparedStatement st = con.prepareStatement(updateById)){
            st.setString(1,houseHoldDto.getName());
            st.setDate(2,houseHoldDto.getDate());
            st.setString(3,houseHoldDto.getAddress());
            st.setString(4,houseHoldDto.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findPersonInHouse(String id) {
        StringBuilder sb = new StringBuilder();
        try(Connection con = ConnectData.getConnection(); PreparedStatement st = con.prepareStatement(findPersonInHouse)){
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                sb = sb.append(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(sb);

    }
}
