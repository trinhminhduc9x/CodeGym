package test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.dto.CategoryView;
import test.model.Category;
import test.model.Product;

import java.util.Optional;

public interface ICategoryService {

    Page<CategoryView> getAllView (Pageable pageable);

    void save(Category category);

    Optional<Category> findById(Integer id);

    void update(Category category);

    void deleteLogical(Integer id);

    Page<CategoryView> getAllView(String nameSearch, String dateInSearch, String dateEndSearch, Pageable pageable);




}
