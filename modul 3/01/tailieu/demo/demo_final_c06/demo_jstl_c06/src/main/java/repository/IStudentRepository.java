package repository;

import dto.StudentDto;
import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    List<StudentDto> search(String name, String account, String class_id);
    Student findById(int id);
    boolean add(Student student);
    boolean delete(int id);
}
