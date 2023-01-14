package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.dto.CategoryView;
import test.model.Category;
import test.repository.CategoryRepository;
import test.service.ICategoryService;

import java.util.Optional;


@Service
public class categoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Page<CategoryView> getAllView(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }


    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteLogical(Integer id) {
        categoryRepository.deleteById(id);
    }


    @Override
    public Page<CategoryView> getAllView(String nameSearch, String dateInSearch, String dateEndSearch, Pageable pageable) {
        return categoryRepository.search(nameSearch, dateInSearch, dateEndSearch, pageable);
    }

}
