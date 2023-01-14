package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void add(Student student);
    void delete(int id);
}
