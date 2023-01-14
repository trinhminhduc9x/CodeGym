package service.impl;

import dto.StudentDto;
import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;
import validation.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService  implements IStudentService {
    private IStudentRepository  studentRepository = new StudentRepository();
    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentDto> search(String name, String account, String className) {
        return studentRepository.search(name,account,className);
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Map<String, String> add(Student student) {
        // validate dữ liệu
        Map<String,String> errorMap = new HashMap<>();
        if ("".equals(student.getEmail())){
            errorMap.put("email", "Email không được để trống!!");
        }else if (!Validation.checkEmail(student.getEmail())){
            errorMap.put("email", "Email không đúng định dạng");
        }
        if (student.getPoint()<0){
            errorMap.put("point", "Điểm phải lớn hơn 0");
        }else if (student.getPoint()>10){
            errorMap.put("point", "Điểm phải nhỏ hơn  hoặc bằng 10");
        }
        // lưu và db
        if (errorMap.size()==0){
            boolean check= studentRepository.add(student);
        }
         return errorMap;
    }

    @Override
    public boolean delete(int id) {
          return studentRepository.delete(id);
    }


}
