package casestudy.service.impl.employee;

import casestudy.model.employee.Employee;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.repository.employee.IEmployeeRepository;
import casestudy.service.customer.ICustomerTypeService;
import casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository repository;



    @Override
    public List<Employee> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Employee> findPageNameAll(Pageable pageable, String name) {
        return repository.findAllByName(pageable,"%"+ name + "%");
    }
}
