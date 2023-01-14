package repository.facility.impl;

import model.facility.FacilityType;
import model.facility.RentType;
import repository.BaseRepository;
import repository.facility.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private String FIND_ALL_FACILITY_TYPE = "select * from facility_type";
    @Override
    public List<FacilityType> FindAll() {
        List<FacilityType>facilityTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_FACILITY_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int facilityTypeId = resultSet.getInt("facility_type_id");
                 String facilityTypeName = resultSet.getString("facility_type_name");
                FacilityType facilityType = new FacilityType(facilityTypeId,facilityTypeName);
                facilityTypeList.add(facilityType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityTypeList;
    }

    @Override
    public boolean addFacilityType(FacilityType facilityType) {
        return false;
    }

    @Override
    public boolean updateFacilityType(FacilityType facilityType) {
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
