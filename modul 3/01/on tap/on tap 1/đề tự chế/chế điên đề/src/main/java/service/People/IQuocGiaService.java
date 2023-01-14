package service.People;

import model.people.QuocGia;

import java.util.List;

public interface IQuocGiaService {
    List<QuocGia> FindAll();
    boolean addCustomerType(QuocGia customerType);
    boolean updateCustomerType(QuocGia customerType);
    boolean deleteCustomerType(int id);
    QuocGia findById(int id);
}
