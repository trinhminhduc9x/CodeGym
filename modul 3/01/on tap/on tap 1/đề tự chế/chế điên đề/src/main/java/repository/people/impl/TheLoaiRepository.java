package repository.people.impl;

import model.people.TheLoai;
import model.people.TheLoai;
import repository.BaseRepository;
import repository.people.ITheLoaiRepository;
import service.People.ITheLoaiService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiRepository implements ITheLoaiRepository {
    private final String  FIND_ALL_CUSTOMER_TYPE="select * from quanlyphim.theloai";
    @Override
    public List<TheLoai> FindAll() {
        List<TheLoai> theLoaiList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("SttTheLoai");
                String name = resultSet.getString("TenTheLoai");
                TheLoai theLoai = new TheLoai(id,name);
                theLoaiList.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theLoaiList;
    }

    @Override
    public boolean addCustomerType(TheLoai customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(TheLoai customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public TheLoai findById(int id) {
        return null;
    }
}
