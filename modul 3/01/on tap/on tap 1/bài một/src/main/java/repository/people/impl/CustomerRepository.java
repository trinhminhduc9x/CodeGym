package repository.people.impl;

import model.people.Customer;
import repository.BaseRepository;
import repository.people.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CustomerRepository implements ICustomerRepository {
    private final String FIND_ALL_CUSTOMERS =" SELECT * FROM household.house_hold ";
    private final String ADD_CUSTOMER = " insert into `household`.`house_hold`( id_member,name_House_Hold,number_House_Hold,founding,Address) VALUES ( ?, ?, ?,?,?) ";
    private final String FIND_BY_ID =  " select * from `household`.`house_hold` where id_House_Hold = ? ";
    private final String UPDATE_CUSTOMER = " UPDATE `household`.`house_hold` SET `id_member` = ?, `name_House_Hold` = ?, `number_House_Hold` = ?, `founding` = ?, `Address` = ? WHERE `id_House_Hold` = ? ";
    private final String DELETE_BY_ID = " delete from `household`.`house_hold` where id_House_Hold =? ";


    @Override
    public List<Customer> FindAll() {

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
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdMember());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getNumber());
            preparedStatement.setString(4, customer.getFounding());
            preparedStatement.setString(5, customer.getAddress());

            int check = preparedStatement.executeUpdate();
            return (check==1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdMember());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getNumber());
            preparedStatement.setString(4, customer.getFounding());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6,customer.getId());

            int check = preparedStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            int check = preparedStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idcustomer = resultSet.getInt("id_House_Hold");// điền đúng tên các cột từ đa ta base//
                int customerTypeId = resultSet.getInt("id_member");
                String name = resultSet.getString("name_House_Hold");
                int number = resultSet.getInt("number_House_Hold");
                String founding = resultSet.getString("founding");
                String address = resultSet.getString("Address");
                 customer = new Customer(idcustomer,customerTypeId,name,number,founding,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    private final String SEARCH_CUSTOMER = "select * from household.house_hold where name_House_Hold like ?  " +
            " and id_member like ?";

    @Override
    public List<Customer> searchCustomer(String nameSearch, String customerTypeIdSearch) {
        List<Customer>customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1,"%"+nameSearch+"%");
            preparedStatement.setString(2,"%"+customerTypeIdSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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

}
