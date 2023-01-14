package casestudy.service.facility;


import casestudy.model.customer.Customer;
import casestudy.model.facility.Facility;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService extends IGeneralService<Facility> {
    @Override
    List<Facility> findListAll();

    @Override
    List<Facility> findListById(Integer id);

    @Override
    void save(Facility facility);

    @Override
    Facility findById(Integer id);

    @Override
    void update(Facility facility);

    @Override
    void remove(Integer id);

    @Override
    Page<Facility> findPageNameAll(Pageable pageable, String name);

    Page<Facility> findPageNameFacilityType(Pageable pageable, String name, String FacilityTypeID);

}
