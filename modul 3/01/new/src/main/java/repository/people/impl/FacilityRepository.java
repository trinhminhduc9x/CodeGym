package repository.people.impl;

import model.people.Customer;
import model.people.Facility;
import model.people.Facility;
import repository.BaseRepository;
import repository.people.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private final String FIND_ALL_Facility = "SELECT * FROM furama.facility;";
    private final String ADD_CUSTOMER = "INSERT INTO customer (customer_type_id,customer_name," +
            "date_of_birth,gender,id_card,phone_number,email,address) VALUE (?,?,?,?,?,?,?,?)";
    private final String FIND_BY_ID = "select * from customer where customer_id = ?";
    private final String UPDATE_CUSTOMER = "update customer set customer_type_id =?,customer_name =?," +
            "date_of_birth =?,gender = ?,id_card =?,phone_number=?, email = ?,address =?" +
            "where customer_id = ?;";
    private final String DELETE_BY_ID ="delete from customer where customer_id=?";
    private final String SEARCH_CUSTOMER = "select * from customer where customer_name like ? and phone_number like ? " +
            "and email like ? and customer_type_id like ?";



    @Override
    public List<Facility> FindAll() {

        List<Facility>facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_Facility);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("facility_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom= resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floor");
                String facilityFree = resultSet.getString("facility_free");
                Facility facility = new Facility(id,facilityTypeId,rentTypeId,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloor,facilityFree);
                facilityList.add(facility);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public boolean addFacility(Facility Facility) {
        return false;
    }

    @Override
    public boolean updateFacility(Facility Facility) {
        return false;
    }

    @Override
    public boolean deleteFacility(int id) {
        return false;
    }

    @Override
    public Facility findById(int id) {
        return null;
    }

    @Override
    public List<Facility> searchFacility(String name, String standardRoom, String descriptionOtherConvenience, String Facility_type) {
        return null;
    }

    @Override
    public Map<String, String> checkValidateFacility(Customer customer) {
        return null;
    }

}

