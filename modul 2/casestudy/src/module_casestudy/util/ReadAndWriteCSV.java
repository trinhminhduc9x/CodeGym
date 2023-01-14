package module_casestudy.util;

import module_casestudy.model.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeEmployeeListToCSV(List<Employee> employeeList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            stringList.add(employeeList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }

    public static List<Employee> readEmployeeList(String pathFile) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            employeeList.add(new Employee(array[0], array[1], LocalDate.parse(array[2]), array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5]), array[6], array[7], array[8], Integer.parseInt(array[9])));
        }
        return employeeList;
    }


}
