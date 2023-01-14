package repository.impl;

import model.ClassCG;
import model.Student;
import repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    private static List<ClassCG> classCGList = new ArrayList<>();
    static {
        classCGList.add(new ClassCG(1,"C11"));
        classCGList.add(new ClassCG(2,"C12"));
        studentList.add(new Student(1,"Trần Văn Chánh",true,"12/12/2022",7,"chanhtv",1,"chanhtv"));
        studentList.add(new Student(2,"Nguyễn Văn A",false,"12/12/2022",1,"chanhtv",1,"chanhtv"));
        studentList.add(new Student(3,"Nguyễn Minh Tiến",true,"12/12/2022",4,"chanhtv",1,"chanhtv"));
        studentList.add(new Student(4,"chanh4",true,"12/12/2022",8,"chanhtv",2,"chanhtv"));
        studentList.add(new Student(5,"chanh5",true,"12/12/2022",6,"chanhtv",2,"chanhtv"));
        studentList.add(new Student(6,"chanh6",true,"12/12/2022",5,"chanhtv",3,"chanhtv"));
    }
    @Override
    public List<Student> findAll() {
        // kết nối db
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void delete(int id) {

    }
}
