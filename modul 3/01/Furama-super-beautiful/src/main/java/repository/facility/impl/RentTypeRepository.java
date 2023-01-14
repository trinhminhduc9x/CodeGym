package repository.facility.impl;

import model.facility.RentType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements repository.facility.IRentTypeRepository {
    private String FindAllRentype = "select * from rent_type";

    @Override
    public List<RentType> FindAll() {
        List<RentType>rentTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FindAllRentype);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int rentTypeId = resultSet.getInt("rent_type_id");
                 String rentTypeName = resultSet.getString("rent_type_name");
                 RentType rentType = new RentType(rentTypeId,rentTypeName);
                 rentTypeList.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public boolean addRentType(RentType rentType) {
        return false;
    }

    @Override
    public boolean updateRentType(RentType rentType) {
        return false;
    }

    @Override
    public boolean deleteRentType(int id) {
        return false;
    }

    @Override
    public RentType findById(int id) {
        return null;
    }
}
