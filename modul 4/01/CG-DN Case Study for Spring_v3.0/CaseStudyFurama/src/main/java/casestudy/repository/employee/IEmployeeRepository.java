package casestudy.repository.employee;

import casestudy.model.customer.Customer;
import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = " select *  from employee where name like :name  ", nativeQuery = true)
    Page<Employee> findAllByName(Pageable pageable, @Param("name") String name);
}
