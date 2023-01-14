package repository.impl;

import connection.DBConnect;
import model.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER ="SELECT * FROM household.house_hold";
    private static final String DELETE_CUSTOMER = " delete from khach_hang where ma_khach_hang =? ";
    private static final String INSERT_INTO_CUSTOMER = " insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values (?,?,?,?,?,?,?,?) ";
    private static final String UPDATE_USTOMER = " update khach_hang set ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi =?,ma_loai_khach=? where ma_khach_hang=? ";
    private static final String UPDATE_CUSTOMER = " UPDATE `household`.`house_hold` SET id_member = ?, name_House_Hold = ?, number_House_Hold = ?, founding = ?, Address = ? WHERE id_House_Hold = ?";
    private static final String SELECT_CUSTOMER = " select * from household.house_hold where id_House_Hold = ? ";
    private static final String SEARCH_CUSTOMER = " select * from household.house_hold where name_House_Hold like ?  and Address like ?";



    @Override
    public List<Customer> selectAllCustomer() {
        Connection connection = DBConnect.getConnectDB();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = new Customer();
        Connection connection = DBConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_House_Hold = resultSet.getInt("id_House_Hold");
                int customerTypeId = resultSet.getInt("id_member");
                String name = resultSet.getString("name_House_Hold");
                int number = resultSet.getInt("number_House_Hold");
                String founding = resultSet.getString("founding");
                String address = resultSet.getString("Address");
                customer = new Customer(id_House_Hold,customerTypeId,name,number,founding,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = DBConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdMember());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getNumber());
            preparedStatement.setString(4, customer.getFounding());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean deleteCustomer(int id) {
        Connection connection = DBConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = DBConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdMember());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getNumber());
            preparedStatement.setString(4, customer.getFounding());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public List<Customer> searchByName(String keyName, String keyAddress) {
        Connection connection = DBConnect.getConnectDB();
        Customer customer = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + keyName + "%");
            preparedStatement.setString(2, "%" + keyAddress + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_House_Hold");// điền đúng tên các cột từ đa ta base//
                int customerTypeId = resultSet.getInt("id_member");
                String name = resultSet.getString("name_House_Hold");
                int number = resultSet.getInt("number_House_Hold");
                String founding = resultSet.getString("founding");
                String address = resultSet.getString("Address");
                customer = new Customer(id,customerTypeId,name,number,founding,address);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

}
