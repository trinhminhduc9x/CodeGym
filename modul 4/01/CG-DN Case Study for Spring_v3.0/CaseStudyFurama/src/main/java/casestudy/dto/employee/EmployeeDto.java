package casestudy.dto.employee;

import casestudy.model.employee.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class EmployeeDto implements Validator {

    private Integer id;

    @Size(min = 5, max = 45)
    private String name;

    private String dateOfBirth;
    @NotBlank
    @Pattern(regexp = "[0-9]{9}",
            message = "chứng minh nhân dân có 9 chữ số")
    @Size(min = 1, max = 800)
    private String idCard;

    private String salary;
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


    private Position position;


    private DivisionDto division;


    private EducationDegreeDto educationDegreeDto;


    private User user;


    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String dateOfBirth, String idCard, String salary, String phoneNumber, String email, String address, Position position, DivisionDto division, EducationDegreeDto educationDegreeDto, User user) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.division = division;
        this.educationDegreeDto = educationDegreeDto;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public DivisionDto getDivision() {
        return division;
    }

    public void setDivision(DivisionDto division) {
        this.division = division;
    }

    public EducationDegreeDto getEducationDegreeDto() {
        return educationDegreeDto;
    }

    public void setEducationDegreeDto(EducationDegreeDto educationDegreeDto) {
        this.educationDegreeDto = educationDegreeDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", salary='" + salary + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", division=" + division +
                ", educationDegreeDto=" + educationDegreeDto +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
