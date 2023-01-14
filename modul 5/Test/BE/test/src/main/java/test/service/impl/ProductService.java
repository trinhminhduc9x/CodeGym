package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Product;
import test.repository.ProductRepository;
import test.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }
}
