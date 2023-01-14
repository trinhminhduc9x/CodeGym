package casestudy.service.customer;

import casestudy.model.customer.Customer;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    @Override
    List<Customer> findListAll();

    @Override
    List<Customer> findListById(Integer id);

    @Override
    void save(Customer customer);

    @Override
    Customer findById(Integer id);

    @Override
    void update(Customer customer);

    @Override
    Page<Customer> findPageNameAll(Pageable pageable, String name);

    @Override
    void remove(Integer id);


    Page<Customer> findPageNameEmailType(Pageable pageable, String name,String email,String CustomerTypeID);

}
