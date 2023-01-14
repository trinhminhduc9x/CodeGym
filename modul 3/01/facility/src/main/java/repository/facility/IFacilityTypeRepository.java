package repository.facility;

import model.facility.Facility;
import model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeRepository {
    List<FacilityType> FindAll();
    boolean addFacilityType(FacilityType facilityType);
    boolean updateFacilityType(FacilityType facilityType);
    boolean deleteFacilityType(int id);
    FacilityType findById(int id);
}
