package test.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dto.CategoryDto;
import test.dto.CategoryView;
import test.model.Category;
import test.model.Product;
import test.service.ICategoryService;
import test.service.impl.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryControllerRest {

    @Autowired
    ICategoryService categoryService;
    @Autowired
    ProductService productService;


    @GetMapping("/list/{nameSearch}&{dateInSearch}&{dateEndSearch}")
    public ResponseEntity<Page<CategoryView>> getAllPaging(@PageableDefault(value = 5) Pageable pageable,
                                                           @PathVariable("nameSearch") String nameSearch,
                                                           @PathVariable("dateInSearch") String dateInSearch,
                                                           @PathVariable("dateEndSearch") String dateEndSearch){
        Page<CategoryView> repoDtos = categoryService.getAllView(nameSearch, dateInSearch, dateEndSearch, pageable);
        return new ResponseEntity<>(repoDtos, HttpStatus.OK);
    }

    @GetMapping("/product-list")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productService.findAll() ;
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<Category> deleteRepo(@PathVariable Integer id) {
        Optional<Category> repo = categoryService.findById(id);
        if (!repo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.deleteLogical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRepo(@Valid @RequestBody CategoryDto categoryDto,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editRepo(@Valid @RequestBody CategoryDto categoryDto,
                                      @PathVariable Integer id,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<Category> category = categoryService.findById(id);

        if (category.isPresent()) {
            BeanUtils.copyProperties(categoryDto, category.get());
            categoryService.update(category.get());
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
