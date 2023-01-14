package service.impl;

import com.google.protobuf.WireFormat;
import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public Map<String, String> check(Customer customer) {
        Map<String, String> mapErrors = new HashMap<>();
        if (!customer.getName().isEmpty()) {
            if (!customer.getName().matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$")) {
                mapErrors.put("nameErrors", "Please input right format!");
            }
        } else {
            mapErrors.put("nameErrors", "Please input name!");
        }

        if (!customer.getIdCard().isEmpty()) {
            if (!customer.getIdCard().matches("^([0-9]{11}|[0-9]{9})")) {
                mapErrors.put("idCardErrors", "Please input right format!");
            }
        } else {
            mapErrors.put("idCardErrors", "Please input IdCard!");
        }

        if (!customer.getPhoneNumber().isEmpty()) {
            if (!customer.getPhoneNumber().matches("^(090[0-9]{7})|(091[0-9]{7})|([(84)\\+]90[0-9]{7})|([(84)\\+]91[0-9]{7})$")) {
                mapErrors.put("phoneErrors", "Please input right format!  ex:090XXXXXXX OR 091XXXXXXX OR (84)+91XXXXXXX OR (84)+90XXXXXXXX");
            }
        } else {
            mapErrors.put("phoneErrors", "Please input PhoneNumber!");
        }

        if (!customer.getEmail().isEmpty()) {
            if (!customer.getEmail().matches("^([a-z]+[0-1]*@gmail.[a-z]{1,3})")) {
                mapErrors.put("emailErrors", "Please input right format! ex:trang@gmail.com");
            }
        } else {
            mapErrors.put("emailErrors", "Please input Email !");
        }
        if (!customer.getDateOfBirth().isEmpty()) {
//
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                Date date = simpleDateFormat.parse(customer.getDateOfBirth());
//            } catch (ParseException e) {
//                mapErrors.put("dateErrors", "Day of birth invalid");
//            }

            String pattern = "yyyy-MM-dd";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate birthday = LocalDate.parse(customer.getDateOfBirth(), formatter);
            LocalDate now = LocalDate.now();
            int age = Period.between(birthday, now).getYears();
            if (age < 18) {
                mapErrors.put("dateErrors", " Age must be over 18");
           }

        } else {
            mapErrors.put("dateErrors", "Please input Date Of Birthday");
        }
        LocalDate dayOfBirth = null;
        if (!customer.getDateOfBirth().isEmpty()) {
            try {
                dayOfBirth = LocalDate.parse(customer.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (Exception e) {
                mapErrors.put("dateErrors", "Please input right format!");
            }
        } else {
            mapErrors.put("dateErrors", "Please input day of birth!");}

        return mapErrors;
    }

    @Override
    public List<Customer> searchByName(String keyName, String keyAddress) {
        return customerRepository.searchByName(keyName, keyAddress);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {

        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
}
