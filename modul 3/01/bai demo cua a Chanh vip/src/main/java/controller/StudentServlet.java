package controller;

import dto.StudentDto;
import model.Student;
import service.IClassService;
import service.IStudentService;
import service.impl.ClassService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                // thêm mới
                break;
            case "delete":
                // xoá
                break;
            default:

        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        int point = Integer.parseInt(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));
//        String account = request.getParameter("account");
        Student student = new Student(name, gender, birthday, point, email, classId, email);
        Map<String, String> map = studentService.add(student);
        String mess = "Thêm mới thành công";
        if (map.size()!=0) {
            mess = "Thêm mới không thành công";
            request.setAttribute("map",map);
        }
        request.setAttribute("mess", mess);
        showAddForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                // thêm mới
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                // search
                break;
            default:
                // hiện thị list
                showListStudent(request, response);
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchAccount = request.getParameter("searchAccount");
        String searchClassName = request.getParameter("searchClassName");
        request.setAttribute("classList", classService.findAll());
        List<StudentDto> studentDtoList = studentService.search(searchName,searchAccount,searchClassName);
        request.setAttribute("studentList",studentDtoList);
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int deleteId= Integer.parseInt(request.getParameter("deleteId"));
        boolean check = studentService.delete(deleteId);
        String mess = "Xoá thành công";
        if (!check){
            mess ="Xoá không thành công";
        }
        request.setAttribute("mess",mess);
        showListStudent(request,response);

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("classList", classService.findAll());
        try {
            request.getRequestDispatcher("view/student/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("classList", classService.findAll());
        request.setAttribute("studentList", studentService.findAll());
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
