package casestudy.service.facility;

import casestudy.model.facility.RentType;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRentTypeService extends IGeneralService<RentType> {
    @Override
    List<RentType> findListAll();

    @Override
    List<RentType> findListById(Integer id);

    @Override
    void save(RentType rentType);

    @Override
    RentType findById(Integer id);

    @Override
    void update(RentType rentType);

    @Override
    void remove(Integer id);

    @Override
    Page<RentType> findPageNameAll(Pageable pageable, String name);
}
