package casestudy.service.impl.facility;

import casestudy.model.facility.RentType;
import casestudy.repository.facility.IRentTypeRepository;
import casestudy.service.facility.IFacilityTypeService;
import casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    IRentTypeRepository repository;

    @Override
    public List<RentType> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<RentType> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public RentType findById(Integer id) {
        return null;
    }

    @Override
    public void update(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<RentType> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
