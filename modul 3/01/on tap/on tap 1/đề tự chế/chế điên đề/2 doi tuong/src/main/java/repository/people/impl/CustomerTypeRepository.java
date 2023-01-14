package repository.people.impl;

import model.people.Customer;
import model.people.CustomerType;
import repository.BaseRepository;
import repository.people.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private final String  FIND_ALL_CUSTOMER_TYPE="select * from customer_type;";
    private final String  FIND_CUSTOMER_TYPE_BY_ID="";
    private final String  ADD_CUSTOMER_TYPE="";
    private final String  UPDATE_CUSTOMER_TYPE="";
    private final String  DELETE_CUSTOMER_TYPE="";
    @Override
    public List<CustomerType> FindAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(id,name);
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public boolean addCustomerType(CustomerType customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(CustomerType customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public CustomerType findById(int id) {
        return null;
    }
}
