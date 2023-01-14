package casestudy.service.impl.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.repository.contract.IAttachFacilityRepository;
import casestudy.repository.contract.IContractDetailRepository;
import casestudy.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    IAttachFacilityRepository repository;


    @Override
    public List<AttachFacility> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<AttachFacility> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public AttachFacility findById(Integer id) {
        return null;
    }

    @Override
    public void update(AttachFacility attachFacility) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<AttachFacility> findPageNameAll(Pageable pageable, String name) {
        return null;
    }
}
