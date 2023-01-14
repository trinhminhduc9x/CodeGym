package repository.facility;

import model.facility.Facility;
import model.people.Customer;

import java.util.List;

public interface IFacilityrepository {
    List<Facility> FindAll();
    boolean addFacility(Facility facility);
    boolean updateFacility(Facility facility);
    boolean deleteFacility(int id);
    Facility findById(int id);
}
