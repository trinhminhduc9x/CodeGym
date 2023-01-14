package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
