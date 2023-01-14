package repository.people.impl;

import model.people.DoTuoi;
import model.people.DoTuoi;
import repository.BaseRepository;
import repository.people.IDoTuoiRepository;
import service.People.IDoTuoiService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoTuoiRepository implements IDoTuoiRepository {
    private final String  FIND_ALL_CUSTOMER_TYPE="select * from quanlyphim.dotuoi";
    @Override
    public List<DoTuoi> FindAll() {
        List<DoTuoi> doTuoiList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("SttDoTuoi");
                String name = resultSet.getString("TenDoTuoi");
                DoTuoi doTuoi = new DoTuoi(id,name);
                doTuoiList.add(doTuoi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doTuoiList;
    }
    @Override
    public boolean addCustomerType(DoTuoi customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(DoTuoi customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public DoTuoi findById(int id) {
        return null;
    }
}
