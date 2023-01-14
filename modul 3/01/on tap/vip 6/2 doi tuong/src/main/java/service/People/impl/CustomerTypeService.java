package service.People.impl;

import model.people.Customer;
import model.people.CustomerType;
import repository.people.ICustomerTypeRepository;
import repository.people.impl.CustomerTypeRepository;
import service.People.ICustomerService;
import service.People.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> FindAll() {
        return customerTypeRepository.FindAll();
    }

    @Override
    public boolean addCustomerType(CustomerType customerType) {
        return customerTypeRepository.addCustomerType(customerType);
    }

    @Override
    public boolean updateCustomerType(CustomerType customerType) {
        return customerTypeRepository.updateCustomerType(customerType);
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return customerTypeRepository.deleteCustomerType(id);
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id);
    }
}
