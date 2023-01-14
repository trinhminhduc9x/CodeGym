package repository.people;

import model.people.Customer;
import model.people.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> FindAll();
    boolean addCustomerType(CustomerType customerType);
    boolean updateCustomerType(CustomerType customerType);
    boolean deleteCustomerType(int id);
    CustomerType findById(int id);
}
