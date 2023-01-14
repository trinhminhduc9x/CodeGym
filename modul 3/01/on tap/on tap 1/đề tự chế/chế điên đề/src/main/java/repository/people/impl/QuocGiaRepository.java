package repository.people.impl;

import model.people.QuocGia;
import model.people.QuocGia;
import repository.BaseRepository;
import repository.people.IQuocGiaRepository;
import service.People.IQuocGiaService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuocGiaRepository implements IQuocGiaRepository {
    private final String  FIND_ALL_CUSTOMER_TYPE="select * from quanlyphim.quocgia";
    @Override
    public List<QuocGia> FindAll() {
        List<QuocGia> quocGiaList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("SttQuocGia");
                String name = resultSet.getString("TenQuocGia");
                QuocGia quocGia = new QuocGia(id,name);
                quocGiaList.add(quocGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quocGiaList;
    }

    @Override
    public boolean addCustomerType(QuocGia customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(QuocGia customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public QuocGia findById(int id) {
        return null;
    }
}
