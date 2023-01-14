package service.People;

import model.people.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> FindAll();
    boolean addCustomerType(CustomerType customerType);
    boolean updateCustomerType(CustomerType customerType);
    boolean deleteCustomerType(int id);
    CustomerType findById(int id);
}
