package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.MailBox;
import vn.codegym.service.MailBoxService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mailbox")
public class StudentController {

    @Qualifier("mailBoxServiceImpl")
    @Autowired
    private MailBoxService mailBoxService;

    @GetMapping
    public String showList(Model model) {
        List<MailBox> mailBoxList = mailBoxService.findAll();
        model.addAttribute("mailBoxList", mailBoxList);
        return "list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, consumes = "application/json", produces = "text/html")

    public String showList1(ModelMap modelMap) {
        List<MailBox> mailBoxList = mailBoxService.findAll();
        modelMap.addAttribute("mailBoxList", mailBoxList);
        return "list";
    }

    @GetMapping("/list2")
    public ModelAndView showList2() {
        return new ModelAndView("list",
                "studentList", mailBoxService.findAll());
    }

    @PostMapping
    public String showlistPost(Model model) {
        List<MailBox> mailBoxList = mailBoxService.findAll();
        model.addAttribute("mailBoxList", mailBoxList);
        return "list";
    }


    @GetMapping("/search")
    public ModelAndView showListSearch(@RequestParam(value = "kq", required = false, defaultValue = "") String kq) {
        return new ModelAndView("list", "mailBoxList", mailBoxService.findByName(kq));
    }

    @GetMapping("/create")
    public String showCreatPage(Model model) {
        model.addAttribute("MailBox", new MailBox());
        return "create";

    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute MailBox mailBox,
                                RedirectAttributes redirectAttributes) {
        mailBoxService.save(mailBox);
        redirectAttributes.addFlashAttribute("message", "createStudent : " + mailBox.getLanguages() + "OK");
        return "redirect:/mailbox";
    }
}
