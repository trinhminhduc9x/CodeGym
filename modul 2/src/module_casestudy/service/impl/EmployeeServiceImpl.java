package module_casestudy.service.impl;

import module_casestudy.model.person.Employee;
import module_casestudy.service.EmployeeService;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

    static {
        employeeArrayList.add(new Employee("01", "duc1", "1232143",true, 1, 10355, "Asss", "Asdasd", "adfsdf", 123));
        employeeArrayList.add(new Employee("02", "duc3","1232143", true, 5, 10355, "Asss", "Asdasd", "adfsdf", 123));
        employeeArrayList.add(new Employee("03", "duc2","1232143", true, 4, 10355, "Asss", "Asdasd", "adfsdf", 123));
        employeeArrayList.add(new Employee("04", "duc4","1232143", true, 3, 10355, "Asss", "Asdasd", "adfsdf", 123));

//public Employee(String id, String name, boolean gender, int idNumber, int phoneNumber, String email, String levelEmployee, String locationEmployee, int salaryEmployee) {
    }

    @Override
    public void display() {
        for (Employee s : employeeArrayList) {
            System.out.println(s);
        }
    }

    @Override
    public void add() {
        System.out.println("nhập id");
        String id = scanner.nextLine();
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập ngay sinh");
        String date = scanner.nextLine();
        System.out.println("gioi tinh");
        boolean gioitinh = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập id number");
        int idNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập id Phone");
        int idPhone = Integer.parseInt(scanner.nextLine());
        System.out.println(" nhap email");
        String email = scanner.nextLine();
        System.out.println(" nhap levelEmployee");
        String level = scanner.nextLine();
        System.out.println(" nhap locationEmployee");
        String location = scanner.nextLine();
        System.out.println(" nhap salaryEmployee");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(id, name,date, gioitinh, idNumber, idPhone, email, level, location, salary);
        employeeArrayList.add(employee);
    }

    @Override
    public void edit() {
        display();
        System.out.println(" chon hoc vien can sua ");
        int edit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (edit - 1 == i) {
                System.out.println("nhập id");
                employeeArrayList.get(i).setId(scanner.nextLine());
                System.out.println("nhập tên");
                employeeArrayList.get(i).setName(scanner.nextLine());
                System.out.println("nhập ngay sinh");
                employeeArrayList.get(i).setDateOfbirth(scanner.nextLine());
                System.out.println("gioi tinh");
                employeeArrayList.get(i).setGender(Boolean.parseBoolean(scanner.nextLine()));
                System.out.println("nhập id number");
                employeeArrayList.get(i).setIdNumber(Integer.parseInt(scanner.nextLine()));
                System.out.println("nhập id Phone");
                employeeArrayList.get(i).setPhoneNumber(Integer.parseInt(scanner.nextLine()));
                System.out.println(" nhap email");
                employeeArrayList.get(i).setEmail(scanner.nextLine());
                System.out.println(" nhap levelEmployee");
                employeeArrayList.get(i).setLevelEmployee(scanner.nextLine());
                System.out.println(" nhap locationEmployee");
                employeeArrayList.get(i).setLocationEmployee(scanner.nextLine());
                System.out.println(" nhap salaryEmployee");
                employeeArrayList.get(i).setSalaryEmployee(Integer.parseInt(scanner.nextLine()));
                break;
            }
        }
    }

}
