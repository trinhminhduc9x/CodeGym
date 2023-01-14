package repository.people;

import model.people.FacilityType;
import model.people.rentType;

import java.util.List;
import java.util.Map;

public interface IRentTypeRepository {
    List<rentType> FindAll();
    boolean addFacilityType(rentType FacilityType);
    boolean updateFacilityType(FacilityType FacilityType);
    boolean deleteFacilityType(int id);
    FacilityType findById(int id);
}
