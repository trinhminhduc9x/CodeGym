package repository.people;

import model.people.DoTuoi;

import java.util.List;

public interface IDoTuoiRepository {
    List<DoTuoi> FindAll();
    boolean addCustomerType(DoTuoi customerType);
    boolean updateCustomerType(DoTuoi customerType);
    boolean deleteCustomerType(int id);
    DoTuoi findById(int id);
}
