package repository.people.impl;

import model.people.Customer;
import repository.BaseRepository;
import repository.people.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CustomerRepository implements ICustomerRepository {
    private final String FIND_ALL_CUSTOMERS = "SELECT * FROM household.house_hold";
//    private final String ADD_CUSTOMER = "INSERT INTO customer (customer_type_id,customer_name," +
//            "date_of_birth,gender,id_card,phone_number,email,address) VALUE (?,?,?,?,?,?,?,?)";
//    private final String FIND_BY_ID = "select * from customer where customer_id = ?";
   private final String UPDATE_CUSTOMER = "update household.house_hold set id_House_Hold =?,id_member =?," +
            "name_House_Hold =?,number_House_Hold = ?,founding =?,Address=?, " ;
//    private final String DELETE_BY_ID ="delete from customer where customer_id=?";
//    private final String SEARCH_CUSTOMER = "select * from customer where customer_name like ? and phone_number like ? " +
//            "and email like ? and customer_type_id like ?";


    @Override
    public List<Customer> FindAll() {
// nhớ thay đổi tên biến cho đúng với đối tượng đang sử dụng đển hiển thị
                List<Customer>customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_House_Hold");// điền đúng tên các cột từ đa ta base//
                int customerTypeId = resultSet.getInt("id_member");
                String name = resultSet.getString("name_House_Hold");
                int number = resultSet.getInt("number_House_Hold");
                String founding = resultSet.getString("founding");
                String address = resultSet.getString("Address");
                Customer customer = new Customer(id,customerTypeId,name,number,founding,address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }


    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> searchCustomer(String name, String phone, String email, String customerTypeId) {
        return null;
    }

//    @Override
//    public boolean addCustomer(Customer customer) {
//        Connection connection = BaseRepository.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
//            preparedStatement.setInt(1,customer.getCustomerTypeId());
//            preparedStatement.setString(2,customer.getName());
//            preparedStatement.setDate(3, Date.valueOf(customer.getDateOfBirth()));
//            preparedStatement.setBoolean(4,customer.isGender());
//            preparedStatement.setString(5,customer.getIdCard());
//            preparedStatement.setString(6,customer.getPhoneNumber());
//            preparedStatement.setString(7,customer.getEmail());
//            preparedStatement.setString(8,customer.getAddress());
//
//            int check = preparedStatement.executeUpdate();
//            return (check==1);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setInt(2,customer.getIdMember());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setInt(4,customer.getNumber());
            preparedStatement.setString(5,customer.getFounding());
            preparedStatement.setString(6,customer.getAddress());


            int check = preparedStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public boolean deleteCustomer(int id) {
//        Connection connection = BaseRepository.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
//            preparedStatement.setInt(1,id);
//            int check = preparedStatement.executeUpdate();
//            return (check==1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

/*
    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerTypeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = Boolean.parseBoolean(resultSet.getString("gender"));
                String idCard= resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id,customerTypeId,name,dateOfBirth,gender,idCard,phoneNumber,email,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
*/

//    @Override
//    public List<Customer> searchCustomer(String nameSearch, String phoneSearch,String emailSearch, String customerTypeIdSearch) {
//        List<Customer>customerList = new ArrayList<>();
//        Connection connection = BaseRepository.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
//            preparedStatement.setString(1,"%"+nameSearch+"%");
//            preparedStatement.setString(2,"%"+phoneSearch+"%");
//            preparedStatement.setString(3,"%"+emailSearch+"%");
//            preparedStatement.setString(4,"%"+customerTypeIdSearch+"%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("customer_id");
//                int customerTypeId = resultSet.getInt("customer_type_id");
//                String name = resultSet.getString("customer_name");
//                String dateOfBirth = resultSet.getString("date_of_birth");
//                boolean gender = Boolean.parseBoolean(resultSet.getString("gender"));
//                String idCard = resultSet.getString("id_card");
//                String phoneNumber = resultSet.getString("phone_number");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//                Customer customer = new Customer(id, customerTypeId, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
//                customerList.add(customer);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customerList;
//    }

}