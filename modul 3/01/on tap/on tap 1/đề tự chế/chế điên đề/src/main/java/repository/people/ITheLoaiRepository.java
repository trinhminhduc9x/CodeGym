package repository.people;


import model.people.TheLoai;

import java.util.List;

public interface ITheLoaiRepository {
    List<TheLoai> FindAll();
    boolean addCustomerType(TheLoai customerType);
    boolean updateCustomerType(TheLoai customerType);
    boolean deleteCustomerType(int id);
    TheLoai findById(int id);
}
