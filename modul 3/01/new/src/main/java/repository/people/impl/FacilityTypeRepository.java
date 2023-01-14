package repository.people.impl;

import model.people.FacilityType;
import model.people.FacilityType;
import repository.BaseRepository;
import repository.people.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private final String  FIND_ALL_FacilityType="SELECT * FROM furama.facility_type;";
    private final String  FIND_CUSTOMER_TYPE_BY_ID="";
    private final String  ADD_CUSTOMER_TYPE="";
    private final String  UPDATE_CUSTOMER_TYPE="";
    private final String  DELETE_CUSTOMER_TYPE="";
    @Override
    public List<FacilityType> FindAll() {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_FacilityType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id= resultSet.getInt("facility_type_id");
                String name = resultSet.getString("facility_type_name");
                FacilityType facilityType = new FacilityType(id,name);
                facilityTypeList.add(facilityType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityTypeList;
    }

    @Override
    public boolean addFacilityType(FacilityType FacilityType) {
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
