package service.facility;

import model.facility.Facility;

import java.util.List;
import java.util.Map;

public interface IFacilityService {
    List<Facility> FindAll();
    boolean addFacility(Facility facility);
    boolean updateFacility(Facility facility);
    boolean deleteFacility(int id);
    Facility findById(int id);
    Map<String, String> checkValidate(Facility facility);
}
