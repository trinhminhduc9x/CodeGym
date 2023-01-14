package repository.facility.impl;

import model.facility.Facility;
import model.facility.FacilityType;
import repository.BaseRepository;
import repository.facility.IFacilityrepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityrepository {
    private String FIND_ALL_FACILITY = "select * from facility";
    private String ADD_FACILITY = "insert into facility (facility_name,area,cost," +
            "max_people,rent_type_id,facility_type_id,standard_room,description_other_convenience" +
            ",pool_area,number_of_floor,facility_free)\n" +
            "value(?,?,?,?,?,?,?,?,?,?,?)";
    private String UPDATE_FACILITY = "update facility set  facility_name = ?," +
            "area =?,cost =?,max_people=?,  rent_type_id =?,facility_type_id=?," +
            " standard_room =?,description_other_convenience=?,  pool_area =?" +
            ",number_of_floor=?, facility_free =?where facility_id = ?";
    private String DELETE_FACILITY = "delete from facility where facility_id =?";
    private String FIND_FACILITY_BY_ID = "select * from facility where facility_id = ?";

    @Override
    public List<Facility> FindAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_ALL_FACILITY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int facilityId = resultSet.getInt("facility_id");
                 String facilityName = resultSet.getString("facility_name");
                 int area = resultSet.getInt("area");
                 double cost = resultSet.getDouble("cost");
                 int maxPeople =resultSet.getInt("max_people");
                 int rentTypeId  =resultSet.getInt("rent_type_id");
                 int facilityTypeId =resultSet.getInt("facility_type_id");
                 String standardRoom = resultSet.getString("standard_room");
                 String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                 double poolArea = resultSet.getDouble("pool_area");
                 int numberOfFloor = resultSet.getInt("number_of_floor");
                 String facilityFree= resultSet.getString("facility_free");
                Facility facility = new Facility(facilityId,facilityName,area,cost,maxPeople,rentTypeId,facilityTypeId,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloor,facilityFree);
                facilityList.add(facility);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public boolean addFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
                PreparedStatement preparedStatement =connection.prepareStatement(ADD_FACILITY);

            preparedStatement.setString(1,facility.getFacilityName());
            preparedStatement.setInt(2,facility.getArea());
            preparedStatement.setDouble(3,facility.getCost());
            preparedStatement.setInt(4,facility.getMaxPeople());
            preparedStatement.setInt(5,facility.getRentTypeId());
            preparedStatement.setInt(6,facility.getFacilityTypeId());
            preparedStatement.setString(7,facility.getStandardRoom());
            preparedStatement.setString(8,facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9,facility.getPoolArea());
            preparedStatement.setInt(10,facility.getNumberOfFloor());
            preparedStatement.setString(11,facility.getFacilityFree());

           int check = preparedStatement.executeUpdate();
           return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FACILITY);

            preparedStatement.setString(1,facility.getFacilityName());
            preparedStatement.setInt(2,facility.getArea());
            preparedStatement.setDouble(3,facility.getCost());
            preparedStatement.setInt(4,facility.getMaxPeople());
            preparedStatement.setInt(5,facility.getRentTypeId());
            preparedStatement.setInt(6,facility.getFacilityTypeId());
            preparedStatement.setString(7,facility.getStandardRoom());
            preparedStatement.setString(8,facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9,facility.getPoolArea());
            preparedStatement.setInt(10,facility.getNumberOfFloor());
            preparedStatement.setString(11,facility.getFacilityFree());
            preparedStatement.setInt(12,facility.getFacilityId());

            int check = preparedStatement.executeUpdate();
            return (check==1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteFacility(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FACILITY);
            preparedStatement.setInt(1,id);
            int check= preparedStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Facility findById(int id) {
        Facility facility = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FACILITY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int facilityId = resultSet.getInt("facility_id");
                String facilityName = resultSet.getString("facility_name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople =resultSet.getInt("max_people");
                int rentTypeId  =resultSet.getInt("rent_type_id");
                int facilityTypeId =resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floor");
                String facilityFree= resultSet.getString("facility_free");
                facility = new Facility(facilityId,facilityName,area,cost,maxPeople,rentTypeId,facilityTypeId,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloor,facilityFree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facility;
    }
}
