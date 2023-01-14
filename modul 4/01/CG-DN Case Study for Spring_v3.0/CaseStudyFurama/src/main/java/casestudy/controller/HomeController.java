package casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
    @GetMapping(value = " ")
    public String Home (){
        return "Home";
    }

    @GetMapping(value = "/login")
    public String show(){
        return "myLogin";
    }
}
