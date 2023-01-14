package repository.people;

import model.people.Phim;
import model.people.Phim;

import java.util.List;

public interface IPhimRepository {
    List<Phim> FindAll();
    boolean addCustomer(Phim customer);
    boolean updateCustomer(Phim customer);
    boolean deleteCustomer(int id);
    Phim findById(int id);
    List<Phim>searchCustomer(String name,String phone,String email,String customerTypeId);
}
