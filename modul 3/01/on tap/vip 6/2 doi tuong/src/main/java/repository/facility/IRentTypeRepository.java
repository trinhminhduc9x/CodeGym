package repository.facility;

import model.facility.Facility;
import model.facility.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> FindAll();
    boolean addRentType(RentType rentType);
    boolean updateRentType(RentType rentType);
    boolean deleteRentType(int id);
    RentType findById(int id);
}
