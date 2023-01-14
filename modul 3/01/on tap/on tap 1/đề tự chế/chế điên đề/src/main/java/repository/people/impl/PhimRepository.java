package repository.people.impl;

import model.people.Phim;
import model.people.Phim;
import repository.BaseRepository;
import repository.people.IPhimRepository;
import service.People.IPhimService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhimRepository implements IPhimRepository {
    private final String FIND_ALL_CUSTOMERS = "SELECT * FROM quanlyphim.phim";
//    private final String ADD_CUSTOMER = "INSERT INTO customer (customer_type_id,customer_name," +
//            "date_of_birth,gender,id_card,phone_number,email,address) VALUE (?,?,?,?,?,?,?,?)";
//    private final String FIND_BY_ID = "select * from customer where customer_id = ?";
//    private final String UPDATE_CUSTOMER = "update customer set customer_type_id =?,customer_name =?," +
//            "date_of_birth =?,gender = ?,id_card =?,phone_number=?, email = ?,address =?" +
//            "where customer_id = ?;";
//    private final String DELETE_BY_ID ="delete from customer where customer_id=?";
    @Override
    public List<Phim> FindAll() {
        List<Phim>phimList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int SttPhim = resultSet.getInt("SttPhim");
                String TenPhim = resultSet.getString("TenPhim");
                String NgayChieuPhim = resultSet.getString("NgayChieuPhim");
                int SttTheLoai = resultSet.getInt("SttTheLoai");
                int SttQuocGia = resultSet.getInt("SttQuocGia");
                int SttDoTuoi = resultSet.getInt("SttDoTuoi");
                Phim phim = new Phim(SttPhim,TenPhim,NgayChieuPhim,SttTheLoai,SttQuocGia,SttDoTuoi);
                phimList.add(phim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phimList;
    }

    @Override
    public boolean addCustomer(Phim customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Phim customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }



    @Override
    public Phim findById(int id) {
        return null;
    }

    @Override
    public List<Phim> searchCustomer(String name, String phone, String email, String customerTypeId) {
        return null;
    }


}
