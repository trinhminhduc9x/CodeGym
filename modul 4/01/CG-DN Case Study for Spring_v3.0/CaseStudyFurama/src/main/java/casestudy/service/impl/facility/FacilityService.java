package casestudy.service.impl.facility;

import casestudy.model.facility.Facility;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.repository.facility.IFacilityRepository;
import casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    IFacilityRepository repository;

    @Override
    public List<Facility> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<Facility> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(Facility facility) {
        repository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return repository.findById(id).orElse(new Facility());
    }


    @Override
    public void update(Facility facility) {
        repository.save(facility);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Facility> findPageNameAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Page<Facility> findPageNameFacilityType(Pageable pageable, String name, String FacilityTypeID) {
        return this.repository.findAllByNameAndFacilityType(pageable, "%" + name + "%", "%" + FacilityTypeID + "%");
    }
}
