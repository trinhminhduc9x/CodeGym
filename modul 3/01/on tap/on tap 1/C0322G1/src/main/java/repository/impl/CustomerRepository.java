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
    private static final String SELECT_ALL_CUSTOMER = " select *from khach_hang ";
    private static final String DELETE_CUSTOMER = " delete from khach_hang where ma_khach_hang =? ";
    private static final String INSERT_INTO_CUSTOMER = " insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values (?,?,?,?,?,?,?,?) ";
    private static final String UPDATE_CUSTOMER = " update khach_hang set ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi =?,ma_loai_khach=? where ma_khach_hang=? ";
    private static final String SELECT_CUSTOMER = " select * from khach_hang where ma_khach_hang = ? ";
    private static final String SEARCH_CUSTOMER = " select * from `khach_hang` where `ho_ten` like ?  and `dia_chi` like ?";


    @Override
    public List<Customer> selectAllCustomer() {
        Connection connection = DBConnect.getConnectDB();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_khach_hang");
                int customer_type_id = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                String date_of_birth = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String id_card = resultSet.getString("so_cmnd");
                String phone_number = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address);
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
                int idCustomer = resultSet.getInt("ma_khach_hang");
                int customerTypeId = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(idCustomer, customerTypeId, name, birthday, gender, idCard, phoneNumber, email, address);
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
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getDateOfBirth());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
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
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getDateOfBirth());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            preparedStatement.setInt(9, customer.getId());
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
                int idCustomer = resultSet.getInt("ma_khach_hang");
                int customerTypeId = resultSet.getInt("ma_loai_khach");
                String nameCustomer = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String addressCustomer = resultSet.getString("dia_chi");
                customer = new Customer(idCustomer, customerTypeId, nameCustomer, birthday, gender, idCard, phoneNumber, email, addressCustomer);
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
