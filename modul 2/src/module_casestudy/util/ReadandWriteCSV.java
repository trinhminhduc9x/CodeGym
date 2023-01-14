package module_casestudy.util;

import module_casestudy.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class eadandWriteCSV {
    public static void writeListToCSV(List<Employee> employeeList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee s : employeeList) {
                bufferedWriter.write(s.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> employeeList(String pathFile) {
        List<Employee> employeeList = new ArrayList<Employee>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Employee employee = new Employee(array[0], array[1],array[2], Boolean.parseBoolean(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), array[6], array[7], array[8], Integer.parseInt(array[9]));
//    public Employee(String id, String name, boolean gender, int idNumber, int phoneNumber, String email, String levelEmployee, String locationEmployee, int salaryEmployee)
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return employeeList;
    }

    private static class Employee {
    }
}
