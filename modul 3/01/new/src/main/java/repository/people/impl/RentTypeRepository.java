package repository.people.impl;

import model.people.CustomerType;
import model.people.FacilityType;
import model.people.rentType;
import repository.BaseRepository;
import repository.people.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RentTypeRepository implements IRentTypeRepository {
    private final String FIND_ALL_FacilityType = "SELECT * FROM furama.facility_type;";
    private final String FIND_CUSTOMER_TYPE_BY_ID = "";
    private final String ADD_CUSTOMER_TYPE = "";
    private final String UPDATE_CUSTOMER_TYPE = "";
    private final String DELETE_CUSTOMER_TYPE = "";


    @Override
    public List<rentType> FindAll() {
        List<rentType> rentTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_FacilityType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                rentType rentType = new rentType(id, name);
                rentTypeList.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public boolean addFacilityType(rentType FacilityType) {
        return false;
    }

    @Override
    public boolean updateFacilityType(FacilityType FacilityType) {
        return false;
    }

    @Override
    public boolean deleteFacilityType(int id) {
        return false;
    }

    @Override
    public FacilityType findById(int id) {
        return null;
    }
}



