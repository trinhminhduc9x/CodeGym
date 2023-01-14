package service.People.impl;

import model.people.Customer;
import model.people.Facility;
import service.People.IFacilityService;

import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    @Override
    public List<Facility> FindAll() {
        return null;
    }

    @Override
    public boolean addFacility(Facility Facility) {
        return false;
    }

    @Override
    public boolean updateFacility(Facility Facility) {
        return false;
    }

    @Override
    public boolean deleteFacility(int id) {
        return false;
    }

    @Override
    public Facility findById(int id) {
        return null;
    }

    @Override
    public List<Facility> searchFacility(String name, String standardRoom, String descriptionOtherConvenience, String Facility_type) {
        return null;
    }

    @Override
    public Map<String, String> checkValidateFacility(Customer customer) {
        return null;
    }
}
