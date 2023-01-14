package repository.people.impl;

import model.people.Customer;
import repository.BaseRepository;
import repository.people.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CustomerRepository implements ICustomerRepository {
    private final String FIND_ALL_CUSTOMERS = "SELECT * FROM PhongTro";
    private final String ADD_CUSTOMER = "INSERT INTO PhongTro (TenNguoiThueTro,SoDienThoai,GhiChu,STTHinhThucThanhToan) VALUE (?,?,?,?)";
    private final String FIND_BY_ID = "select * from PhongTro where MaPhongTro = ?";
    private final String UPDATE_CUSTOMER = "update PhongTro set STTHinhThucThanhToan =?,TenNguoiThueTro =?," +
            "SoDienThoai=?, GhiChu = ?" +
            "where MaPhongTro = ?;";
    private final String DELETE_BY_ID ="delete from PhongTro where MaPhongTro=?";


    @Override
    public List<Customer> FindAll() {

        List<Customer>customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int id = resultSet.getInt("MaPhongTro");
                 int customerTypeId = resultSet.getInt("STTHinhThucThanhToan");
                 String name = resultSet.getString("TenNguoiThueTro");
                 String phoneNumber = resultSet.getString("SoDienThoai");
                 String address = resultSet.getString("GhiChu");
                 Customer customer = new Customer(id,customerTypeId,name,phoneNumber,address);
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

            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getPhoneNumber());
            preparedStatement.setString(3,customer.getAddress());
            preparedStatement.setInt(4,customer.getCustomerTypeId());
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
            preparedStatement.setInt(1,customer.getCustomerTypeId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getPhoneNumber());
            preparedStatement.setString(4,customer.getAddress());
            preparedStatement.setInt(5,customer.getId());

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
                int customerTypeId = resultSet.getInt("STTHinhThucThanhToan");
                String name = resultSet.getString("TenNguoiThueTro");
                String phoneNumber = resultSet.getString("SoDienThoai");
                String address = resultSet.getString("GhiChu");
               customer = new Customer(id,customerTypeId,name,phoneNumber,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    private final String SEARCH_CUSTOMER = "select * from PhongTro where TenNguoiThueTro like ? and SoDienThoai like ? " +
            " and STTHinhThucThanhToan like ?";

    @Override
    public List<Customer> searchCustomer(String nameSearch, String phoneSearch, String customerTypeIdSearch) {
        List<Customer>customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1,"%"+nameSearch+"%");
            preparedStatement.setString(2,"%"+phoneSearch+"%");
            preparedStatement.setString(3,"%"+customerTypeIdSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("MaPhongTro");
                int customerTypeId = resultSet.getInt("STTHinhThucThanhToan");
                String name = resultSet.getString("TenNguoiThueTro");
                String phoneNumber = resultSet.getString("SoDienThoai");
                String address = resultSet.getString("GhiChu");
                Customer customer = new Customer(id,customerTypeId,name,phoneNumber,address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
