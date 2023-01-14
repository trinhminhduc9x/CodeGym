package casestudy.service.impl.customer;

import casestudy.model.customer.Customer;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository repository;

    @Override
    public List<Customer> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<Customer> findListById(Integer id) {
        return repository.findListById(id);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(new Customer());
    }

    @Override
    public void update(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteLogical(id);
    }


    @Override
    public Page<Customer> findPageNameAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Page<Customer> findPageNameEmailType(Pageable pageable, String name, String email, String CustomerTypeID) {
        return this.repository.findAllByNameAndEmailAndCustomerTypeID(pageable,"%"+ name + "%","%"+ email + "%","%"+ CustomerTypeID + "%");
    }
}
