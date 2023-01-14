package service;

import dto.StudentDto;
import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<StudentDto> findAll();
    List<StudentDto> search(String name, String account, String class_id);
    Student findById(int id);
    Map<String, String> add(Student student);
    boolean delete(int id);
}
