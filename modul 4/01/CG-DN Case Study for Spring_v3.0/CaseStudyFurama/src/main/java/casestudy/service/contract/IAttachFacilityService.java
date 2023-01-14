package casestudy.service.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachFacilityService extends IGeneralService<AttachFacility> {
    @Override
    List<AttachFacility> findListAll();

    @Override
    List<AttachFacility> findListById(Integer id);

    @Override
    void save(AttachFacility attachFacility);

    @Override
    AttachFacility findById(Integer id);

    @Override
    void update(AttachFacility attachFacility);

    @Override
    void remove(Integer id);

    @Override
    Page<AttachFacility> findPageNameAll(Pageable pageable, String name);
}
