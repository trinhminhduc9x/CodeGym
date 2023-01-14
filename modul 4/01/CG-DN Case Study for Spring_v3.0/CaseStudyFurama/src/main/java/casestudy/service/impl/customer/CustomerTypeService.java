package casestudy.service.impl.customer;

import casestudy.model.customer.CustomerType;
import casestudy.repository.customer.IcustomerTypeRepository;
import casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    public IcustomerTypeRepository repository;

    @Override
    public List<CustomerType> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<CustomerType> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(CustomerType customerType) {
        repository.save(customerType);
    }

    @Override
    public CustomerType findById(Integer id) {
        return repository.findById(id).orElse(new CustomerType());
    }

    @Override
    public void update(CustomerType customerType) {
        repository.save(customerType);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<CustomerType> findPageNameAll(Pageable pageable, String name) {
        return repository.findAllByName(pageable, "%" + name + "%");
    }
}
