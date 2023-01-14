package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    void add(Student student);
    void delete(int id);
}
