package com.spring_boot.controller;

import com.spring_boot.dto.BlogDto;
import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.service.ICategoryService;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(3) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam(required = false, defaultValue = "") String note) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Blog> blogPage = blogService.findAll(pageable, keyName, note);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("name", keyName);
        model.addAttribute("note", note);

        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogDto", new BlogDto());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@Validated
                       @ModelAttribute("blogDto") BlogDto blogDto
            , BindingResult bindingResult
            , Model model) {
        new BlogDto().validate(blogDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "/blog/create";
        } else {
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto, blog);
            blogService.save(blog);
            return "redirect:/blog/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        blogService.remove(id);
        return "redirect:/blog/list";
    }


}