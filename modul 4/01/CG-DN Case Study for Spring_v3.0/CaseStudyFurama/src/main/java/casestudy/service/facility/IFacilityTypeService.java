package casestudy.service.facility;

import casestudy.model.facility.FacilityType;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityTypeService extends IGeneralService<FacilityType> {
    @Override
    List<FacilityType> findListAll();

    @Override
    List<FacilityType> findListById(Integer id);

    @Override
    void save(FacilityType facilityType);

    @Override
    FacilityType findById(Integer id);

    @Override
    void update(FacilityType facilityType);

    @Override
    void remove(Integer id);

    @Override
    Page<FacilityType> findPageNameAll(Pageable pageable, String name);
}
