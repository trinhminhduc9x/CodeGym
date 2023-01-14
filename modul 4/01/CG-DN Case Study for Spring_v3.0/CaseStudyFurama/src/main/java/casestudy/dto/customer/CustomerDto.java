package casestudy.dto.customer;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class CustomerDto implements Validator {

    private Integer id;

    private CustomerTypeDto customerTypeDto;
    @Size(min = 5, max = 45)
    private String name;
    private String dateOfBirth;
    private String gender;
    @NotBlank
    @Pattern(regexp = "[0-9]{9}",
            message = "chứng minh nhân dân có 9 chữ số")
    @Size(min = 1, max = 800)
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "điền số điện thoại bắt đầu bằng 0 hoặc 84 ")
    @Size(min = 1, max = 800)
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "^(\\w+)@(\\w+)$",
            message = "điền email theo dang abc@abc ")
    @Size(min = 1, max = 800)
    private String email;
    private String address;

    private String id_delete;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, CustomerTypeDto customerTypeDto, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String address, String id_delete) {
        this.id = id;
        this.customerTypeDto = customerTypeDto;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.id_delete = id_delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerTypeDto getCustomerType() {
        return customerTypeDto;
    }

    public void setCustomerType(CustomerTypeDto customerTypeDto) {
        this.customerTypeDto = customerTypeDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId_delete() {
        return id_delete;
    }

    public void setId_delete(String id_delete) {
        this.id_delete = id_delete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
