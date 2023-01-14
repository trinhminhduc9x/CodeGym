package service.facility;

import model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> FindAll();
    boolean addRentType(RentType rentType);
    boolean updateRentType(RentType rentType);
    boolean deleteRentType(int id);
    RentType findById(int id);
}
