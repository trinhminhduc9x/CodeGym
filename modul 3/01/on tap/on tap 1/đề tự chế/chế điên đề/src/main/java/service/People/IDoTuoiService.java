package service.People;

import model.people.DoTuoi;

import java.util.List;

public interface IDoTuoiService {
    List<DoTuoi> FindAll();
    boolean addCustomerType(DoTuoi customerType);
    boolean updateCustomerType(DoTuoi customerType);
    boolean deleteCustomerType(int id);
    DoTuoi findById(int id);
}
