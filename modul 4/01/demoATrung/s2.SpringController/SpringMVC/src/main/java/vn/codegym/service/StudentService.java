package vn.codegym.service;

import vn.codegym.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
