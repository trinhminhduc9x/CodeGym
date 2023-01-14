package service.People.impl;

import model.people.DoTuoi;
import repository.people.ICustomerRepository;
import repository.people.IDoTuoiRepository;
import repository.people.impl.CustomerRepository;
import repository.people.impl.DoTuoiRepository;
import service.People.IDoTuoiService;
import service.People.IPhimService;

import java.util.List;

public class DoTuoiService implements IDoTuoiService {
    private IDoTuoiRepository doTuoiRepository = new DoTuoiRepository();
    @Override
    public List<DoTuoi> FindAll() {
        return doTuoiRepository.FindAll();
    }

    @Override
    public boolean addCustomerType(DoTuoi customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(DoTuoi customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public DoTuoi findById(int id) {
        return null;
    }
}
