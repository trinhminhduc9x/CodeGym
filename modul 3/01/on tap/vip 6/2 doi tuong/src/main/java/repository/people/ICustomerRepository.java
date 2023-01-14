package repository.people;

import model.people.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> FindAll();
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    Customer findById(int id);
    List<Customer>searchCustomer(String name,String phone,String email,String customerTypeId);
}
