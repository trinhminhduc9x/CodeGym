package service;

import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> selectAllCustomer();
    Customer selectCustomer(int id);
    void insertCustomer(Customer customer);
    boolean deleteCustomer(int id);
    boolean updateCustomer(Customer customer);
    List<Customer> searchByName(String keyName, String keyAddress);

    Map<String,String> check(Customer customer);
}
