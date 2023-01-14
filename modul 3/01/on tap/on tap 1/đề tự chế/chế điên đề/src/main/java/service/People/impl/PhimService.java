package service.People.impl;

import model.people.Phim;
import repository.people.IPhimRepository;
import repository.people.impl.PhimRepository;
import service.People.IPhimService;

import java.util.List;
import java.util.Map;

public class PhimService implements IPhimService {
    private IPhimRepository phimService = new PhimRepository();
    @Override
    public List<Phim> FindAll() {
        return phimService.FindAll();
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

    @Override
    public Map<String, String> checkValidateCustomer(Phim customer) {
        return null;
    }
}
