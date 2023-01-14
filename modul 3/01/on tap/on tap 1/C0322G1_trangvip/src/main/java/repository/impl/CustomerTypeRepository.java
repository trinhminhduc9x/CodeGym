package repository.impl;

import connection.DBConnect;
import model.CustomerType;
import repository.ICustomerTypeRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {

    private static final String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM household.member;";
    @Override
    public List<CustomerType> selectAllCustomerType() {
        Connection connection = DBConnect.getConnectDB();
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id_member");
                String name = resultSet.getString("name_member");
                CustomerType customerType = new CustomerType(id,name);
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerTypeList;
    }
}
