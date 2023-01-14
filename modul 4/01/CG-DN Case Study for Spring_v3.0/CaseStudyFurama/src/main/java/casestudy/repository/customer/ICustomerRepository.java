package casestudy.repository.customer;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {


    @Query(value = " select *  from customer where name like :name and email like :email and customer_type_id like :CustomerTypeID and customer.delete_status=0", nativeQuery = true)
    Page<Customer> findAllByNameAndEmailAndCustomerTypeID(Pageable pageable, @Param("name") String name,@Param("email") String email,@Param("CustomerTypeID") String CustomerTypeID);


    @Query(value = " select * from customer where category_id = :id ", nativeQuery = true)
    List<Customer> findListById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update customer set customer.delete_status = 1 where id = :id", nativeQuery = true)
    void deleteLogical(@Param("id") Integer id);
}
