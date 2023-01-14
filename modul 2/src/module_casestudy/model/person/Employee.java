package module_casestudy.model.person;

public class Employee extends Person {
    private String levelEmployee;
    private String locationEmployee;
    private int salaryEmployee;

    public Employee() {
    }

    public Employee(String levelEmployee, String locationEmployee, int salaryEmployee) {
        this.levelEmployee = levelEmployee;
        this.locationEmployee = locationEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public Employee(String id, String name, String dateOfbirth, boolean gender, int idNumber, int phoneNumber, String email, String levelEmployee, String locationEmployee, int salaryEmployee) {
        super(id, name, dateOfbirth, gender, idNumber, phoneNumber, email);
        this.levelEmployee = levelEmployee;
        this.locationEmployee = locationEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public String getLevelEmployee() {
        return levelEmployee;
    }

    public void setLevelEmployee(String levelEmployee) {
        this.levelEmployee = levelEmployee;
    }

    public String getLocationEmployee() {
        return locationEmployee;
    }

    public void setLocationEmployee(String locationEmployee) {
        this.locationEmployee = locationEmployee;
    }

    public int getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(int salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public String getInfoToCSV() {
        return getId() + getName() + getDateOfbirth() + isGender() + getIdNumber() + getPhoneNumber() + getEmail() + getLevelEmployee() + getLocationEmployee() + getSalaryEmployee();
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "levelEmployee='" + levelEmployee + '\'' +
                ", locationEmployee='" + locationEmployee + '\'' +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}
