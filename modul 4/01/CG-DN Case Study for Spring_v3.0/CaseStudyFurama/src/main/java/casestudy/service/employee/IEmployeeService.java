package casestudy.service.employee;

import casestudy.model.employee.Employee;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService  extends IGeneralService<Employee> {
    @Override
    List<Employee> findListAll();

    @Override
    List<Employee> findListById(Integer id);

    @Override
    void save(Employee employee);

    @Override
    Employee findById(Integer id);

    @Override
    void update(Employee employee);

    @Override
    void remove(Integer id);

    @Override
    Page<Employee> findPageNameAll(Pageable pageable, String name);

}
