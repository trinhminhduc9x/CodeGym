package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.ConvertService;

@Controller
@RequestMapping()
public class ConvertController {


    @Autowired
    private ConvertService convertService;

    @GetMapping
    public String home() {
        return "list";
    }

    @GetMapping("/convert")
    public String vnd(@RequestParam double rate, @RequestParam double usd, Model model) {

        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", this.convertService.convert(rate, usd));
        return "list";

    }

}
