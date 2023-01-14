package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository ProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return  ProductRepository.findAll();
    }

    @Override
    public void add(Product product) {
        ProductRepository.add(product);
    }

    @Override
    public Product findById(int id) {

        return ProductRepository.findById(id);
    }

    @Override
    public void update(int id,Product product) {
        ProductRepository.update(id,product);
    }

    @Override
    public void delete(int id) {
        ProductRepository.delete(id);
    }


    @Override
    public Product productDetail(int id) {
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        return ProductRepository.searchByName(name);
    }
}
