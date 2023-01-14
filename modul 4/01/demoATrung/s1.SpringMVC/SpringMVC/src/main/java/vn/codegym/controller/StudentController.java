package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/list")
    public String showList1(ModelMap modelMap){
        List<Student> studentList = studentService.findAll();
        modelMap.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/list2")
    public ModelAndView showList2(){
        return new ModelAndView("list",
                "studentList", studentService.findAll());
    }

    @PostMapping
    public String createStudent(){
            return "list";
    }
}
