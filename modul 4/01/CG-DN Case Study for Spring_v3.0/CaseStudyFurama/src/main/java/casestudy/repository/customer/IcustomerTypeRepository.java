package casestudy.repository.customer;

import casestudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IcustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
    @Query(value = " select * from customer_type where name like :name", nativeQuery = true)
    Page<CustomerType> findAllByName(Pageable pageable, @Param("name") String name);
}
