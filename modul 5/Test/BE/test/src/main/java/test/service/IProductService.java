package test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.model.Category;
import test.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

}
