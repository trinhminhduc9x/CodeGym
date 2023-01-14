package service.People.impl;

import model.people.FacilityType;
import service.People.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    @Override
    public List<FacilityType> FindAll() {
        return null;
    }

    @Override
    public boolean addFacilityType(FacilityType FacilityType) {
        return false;
    }

    @Override
    public boolean updateFacilityType(FacilityType FacilityType) {
        return false;
    }

    @Override
    public boolean deleteFacilityType(int id) {
        return false;
    }

    @Override
    public FacilityType findById(int id) {
        return null;
    }
}
