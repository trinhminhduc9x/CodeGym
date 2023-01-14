package repository.impl;

import model.ClassCG;
import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL = "SELECT * FROM c0622g1.student;";
    private final String INSERT_STUDENT = "insert into student(`name`,birthday, gender,`point`, class_id,`account`) \n" +
            " values (?,?,?,?,?,?)";
    private static List<Student> studentList = new ArrayList<>();
    private static List<ClassCG> classCGList = new ArrayList<>();

    @Override
    public List<Student> findAll() {
       List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement pr = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                int classId = resultSet.getInt("class_id");
                String email = resultSet.getString("email");
                Student student = new Student(id,name,gender,birthday,point,account,classId,email);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  studentList ;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setString(1,student.getName());
            ps.setDate(2, Date.valueOf(student.getBirthday()));
            ps.setBoolean(3,student.isGender());
            ps.setInt(4,student.getPoint());
            ps.setInt(5,student.getClassId());
            ps.setString(6,student.getEmail());
            int num = ps.executeUpdate();
            return (num ==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
