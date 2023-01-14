package repository.impl;

import dto.StudentDto;
import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final String SELECT_ALL ="select * from student;";
    private final String SELECT_ALL_DTO =" select s.*,c.name as class_name from student s join class c on s.class_id=c.id;";
    private final String SEARCH ="select s.*,c.name as class_name from student s left join class c on s.class_id =c.id where s.name like ? and s.account like ? and c.name like ?;";
    private final String DELETE_BY_ID ="call delete_student_by_id(?);";
    private final String INSERT_STUDENT ="insert into student(`name`,birthday, gender," +
                                          "`point`,`account`,class_id,email)values (?,?,?,?,?,?,?);";
    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_BY_ID);
            callableStatement.setInt(1,id);
            return callableStatement.executeUpdate()>=1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }
    @Override
    public List<StudentDto> findAll() {
//        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
//        try {
//            PreparedStatement pr =connection.prepareStatement(SELECT_ALL);
//            ResultSet resultSet = pr.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");// columnLable : tên trường trong database
//                String name = resultSet.getString("name");
//                Boolean gender = resultSet.getBoolean("gender");
//                String birthday = resultSet.getString("birthday");
//                int point = resultSet.getInt("point");
//                String account = resultSet.getString("account");
//                int classId = resultSet.getInt("class_id");
//                String email = resultSet.getString("email");
//                Student student = new Student(id, name, gender, birthday, point, account, classId, email);
//                studentList.add(student);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        List<StudentDto> studentDtoList = new ArrayList<>();
        try {
            PreparedStatement pr =connection.prepareStatement(SELECT_ALL_DTO);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");// columnLable : tên trường trong database
                String name = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                String className = resultSet.getString("class_name");
                String email = resultSet.getString("email");
                StudentDto student = new StudentDto(id, name, gender, birthday, point, account, email,className);
                studentDtoList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> search(String searchName, String searchAccount, String searchClassName) {
        Connection connection = BaseRepository.getConnectDB();
        List<StudentDto> studentDtoList = new ArrayList<>();
        try {
            PreparedStatement pr=connection.prepareStatement(SEARCH);
            pr.setString(1,"%"+searchName+"%");
            pr.setString(2,"%"+searchAccount+"%");
            pr.setString(3,"%"+searchClassName +"%");
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");// columnLable : tên trường trong database
                String name = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                String className = resultSet.getString("class_name");
                String email = resultSet.getString("email");
                StudentDto student = new StudentDto(id, name, gender, birthday, point, account, email,className);
                studentDtoList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentDtoList;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setString(1, student.getName());
            ps.setDate(2, Date.valueOf(student.getBirthday()));
            ps.setBoolean(3, (student.isGender()));
            ps.setInt(4, student.getPoint());
            ps.setString(5, student.getAccount());
            ps.setInt(6, student.getClassId());
            ps.setString(7, student.getEmail());
            int num= ps.executeUpdate();// trả về số hàng bị ảnh hưởng => thêm một hàng=> 1
            return (num==1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
