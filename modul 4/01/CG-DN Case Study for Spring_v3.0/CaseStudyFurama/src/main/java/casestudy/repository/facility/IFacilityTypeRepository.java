package casestudy.repository.facility;

import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {

}
