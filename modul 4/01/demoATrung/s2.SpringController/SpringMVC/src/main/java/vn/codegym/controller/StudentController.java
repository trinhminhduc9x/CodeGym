package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

//    @GetMapping
    @RequestMapping(value = "/student",consumes = "application/json",produces = "application/json")
    public String showList(Model model,ModelMap modelMap){
        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList", studentList);
        modelMap.addAttribute("studentList", studentList);
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


    @GetMapping("/search")
    public ModelAndView showListSearch(@RequestParam(value = "kq",required = false,defaultValue = "") String kq){
        return new ModelAndView("list","studentList",studentService.findByName(kq));
    }

    @GetMapping("/detail/{id:[1-3]")
    public String showDetail (@PathVariable(value = "id") Integer studentId,Model model)
    {
        System.out.println("lay thong tin sinh vien id:" + studentId);
        model.addAttribute("studentID",studentId);
        return "detail";
    }





}
