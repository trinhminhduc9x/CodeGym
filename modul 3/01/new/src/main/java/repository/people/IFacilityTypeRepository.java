package repository.people;


import model.people.FacilityType;

import java.util.List;

public interface IFacilityTypeRepository {
    List<FacilityType> FindAll();
    boolean addFacilityType(FacilityType FacilityType);
    boolean updateFacilityType(FacilityType FacilityType);
    boolean deleteFacilityType(int id);
    FacilityType findById(int id);
}
