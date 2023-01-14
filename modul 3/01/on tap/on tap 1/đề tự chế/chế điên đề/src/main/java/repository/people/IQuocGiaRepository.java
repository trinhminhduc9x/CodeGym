package repository.people;

import model.people.QuocGia;

import java.util.List;

public interface IQuocGiaRepository {
    List<QuocGia> FindAll();
    boolean addCustomerType(QuocGia customerType);
    boolean updateCustomerType(QuocGia customerType);
    boolean deleteCustomerType(int id);
    QuocGia findById(int id);
}
