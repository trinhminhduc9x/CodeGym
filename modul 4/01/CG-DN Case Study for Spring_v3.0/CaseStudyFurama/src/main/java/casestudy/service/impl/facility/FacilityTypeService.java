package casestudy.service.impl.facility;

import casestudy.model.facility.FacilityType;
import casestudy.repository.facility.IFacilityRepository;
import casestudy.repository.facility.IFacilityTypeRepository;
import casestudy.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    IFacilityTypeRepository repository;


    @Override
    public List<FacilityType> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<FacilityType> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(FacilityType facilityType) {

    }

    @Override
    public FacilityType findById(Integer id) {
        return null;
    }

    @Override
    public void update(FacilityType facilityType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<FacilityType> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
