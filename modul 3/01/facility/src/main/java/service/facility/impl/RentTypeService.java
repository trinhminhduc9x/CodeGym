package service.facility.impl;

import model.facility.RentType;
import repository.facility.IRentTypeRepository;
import repository.facility.impl.RentTypeRepository;
import service.facility.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> FindAll() {
        return rentTypeRepository.FindAll();
    }

    @Override
    public boolean addRentType(RentType rentType) {
        return rentTypeRepository.addRentType(rentType);
    }

    @Override
    public boolean updateRentType(RentType rentType) {
        return rentTypeRepository.updateRentType(rentType);
    }

    @Override
    public boolean deleteRentType(int id) {
        return rentTypeRepository.deleteRentType(id);
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id);
    }
}
