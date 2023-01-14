package service.facility.impl;

import model.facility.FacilityType;
import repository.facility.IFacilityTypeRepository;
import repository.facility.impl.FacilityTypeRepository;
import service.facility.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> FindAll() {
        return facilityTypeRepository.FindAll();
    }

    @Override
    public boolean addFacilityType(FacilityType facilityType) {
        return facilityTypeRepository.addFacilityType(facilityType);
    }

    @Override
    public boolean updateFacilityType(FacilityType facilityType) {
        return facilityTypeRepository.updateFacilityType(facilityType);
    }

    @Override
    public boolean deleteFacilityType(int id) {
        return facilityTypeRepository.deleteFacilityType(id);
    }

    @Override
    public FacilityType findById(int id) {
        return facilityTypeRepository.findById(id);
    }
}
