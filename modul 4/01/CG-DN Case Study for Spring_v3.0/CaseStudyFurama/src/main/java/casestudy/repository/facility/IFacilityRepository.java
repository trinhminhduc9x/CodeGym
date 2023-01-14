package casestudy.repository.facility;


import casestudy.model.customer.Customer;
import casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = " select * from facility where name like :name and facility_type like :FacilityTypeID", nativeQuery = true)
    Page<Facility> findAllByNameAndFacilityType(Pageable pageable, @Param("name") String name,@Param("FacilityTypeID") String FacilityTypeID);


    @Query(value = " select * from facility where category_id = :id ", nativeQuery = true)
    List<Facility> findListById(@Param("id") Integer id);
}
