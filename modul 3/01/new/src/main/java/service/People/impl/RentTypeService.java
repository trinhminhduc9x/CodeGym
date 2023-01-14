package service.People.impl;

import model.people.rentType;
import service.People.IRentTypeService;

import java.util.List;
import java.util.Map;

public class RentTypeService implements IRentTypeService {
    @Override
    public List<rentType> FindAll() {
        return null;
    }

    @Override
    public boolean addrentType(rentType rentType) {
        return false;
    }

    @Override
    public boolean updaterentType(rentType rentType) {
        return false;
    }

    @Override
    public boolean deleterentType(int id) {
        return false;
    }

    @Override
    public rentType findById(int id) {
        return null;
    }

    @Override
    public List<rentType> searchrentrentType(String name, String phone, String email, String customerTypeId) {
        return null;
    }

    @Override
    public Map<String, String> checkValidaterentType(rentType rentType) {
        return null;
    }
}
