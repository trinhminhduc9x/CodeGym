package casestudy.dto.employee;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DivisionDto implements Validator {

    private Integer id;


    private String name;

    public DivisionDto() {
    }

    public DivisionDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

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

    @Override
    public String toString() {
        return "DivisionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
