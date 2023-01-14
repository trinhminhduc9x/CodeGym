package service.People.impl;

import model.people.Customer;
import repository.people.ICustomerRepository;
import repository.people.impl.CustomerRepository;
import service.People.ICustomerService;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> FindAll() {
        return customerRepository.FindAll();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> searchCustomer(String name, String phone, String email, String customerTypeId) {
        return customerRepository.searchCustomer(name,phone,email,customerTypeId);
    }

    @Override
    public Map<String, String> checkValidateCustomer(Customer customer) {
        Map<String,String> errorMap =new HashMap<>();

//        Kiểm tra tên
        if (!customer.getName().isEmpty()){
            if (!customer.getName().matches("^[A-Z][a-z]+(\\s[A-Z][a-z]*)*$")){
                errorMap.put("name","Sai Format, Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n" +
                        "viết hoa.");
            }
        } else {
            errorMap.put("name","Tên không được để trống");
        }

//      Kiểm tra ngày sinh
        LocalDate birthday;
        if (!customer.getDateOfBirth().isEmpty()){
            try {
                birthday = LocalDate.parse(customer.getDateOfBirth());
                if (Period.between(birthday,LocalDate.now()).getYears()<18){
                    errorMap.put("birthday","Chưa đủ 18 tuổi");
                }
            } catch (Exception e) {
                errorMap.put("birthday", "Nhập sai format(định dạng ngày là:yyyy-MM-dd");
            }
        } else {
            errorMap.put("name","Ngày sinh không được để trống");
        }

//        Kiểm tra số điện thoại
        if (!customer.getPhoneNumber().isEmpty()){
            if (!customer.getPhoneNumber().matches("^[0|+84][90|91]\\d{8}$")){
                errorMap.put("phone","Nhập sai định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc\n" +
                        "(84)+90xxxxxxx hoặc (84)+91xxxxxxx.");
            }
        }else {
            errorMap.put("phone", "Số điện thoại không được để trống");
        }

//        Kiểm tra số chứng minh thư
        if (!customer.getIdCard().isEmpty()){
            if (!customer.getIdCard().matches("^\\d{9,11}$")){
                errorMap.put("idCard","Sai Format, số cmnd 9-11 chữ số");
            }
        } else {
            errorMap.put("idCard","Số chứng minh không được để trống");
        }

//        Kiểm tra email
        if (!customer.getEmail().isEmpty()){
            if (!customer.getEmail().matches("^\\w+@\\w+.\\w+$")){
                errorMap.put("email","Sai Format(xxx@xxx.xxx)");
            }
        } else {
            errorMap.put("email","Email không được để trống");
        }
        return errorMap;
    }


}
