package service.People;

import model.people.Customer;
import model.people.Facility;

import java.util.List;
import java.util.Map;

public interface IFacilityService {
    List<Facility> FindAll();
    boolean addFacility(Facility Facility);
    boolean updateFacility(Facility Facility);
    boolean deleteFacility(int id);
    Facility findById(int id);
    List<Facility>searchFacility(String name,String standardRoom,String descriptionOtherConvenience,String Facility_type);
    Map<String,String> checkValidateFacility(Customer customer);
}
