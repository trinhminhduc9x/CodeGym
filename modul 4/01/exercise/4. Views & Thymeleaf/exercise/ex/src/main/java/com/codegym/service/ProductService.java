package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> PRODUCT_MAP;

    static {

        PRODUCT_MAP = new HashMap<>();
        PRODUCT_MAP.put(1, new Product(1, "oto", "1000000", "mau xanh","honda"));
        PRODUCT_MAP.put(2, new Product(2, "oto", "2000000", "mau xanh","honda"));
        PRODUCT_MAP.put(3, new Product(3, "oto", "3000000", "mau xanh","honda"));
        PRODUCT_MAP.put(4, new Product(4, "oto", "4000000", "mau xanh","honda"));
        PRODUCT_MAP.put(5, new Product(5, "oto", "5000000", "mau xanh","honda"));
        PRODUCT_MAP.put(6, new Product(6, "oto", "6000000", "mau xanh","honda"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public void save(Product product) {
        PRODUCT_MAP.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_MAP.get(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCT_MAP.put(id, product);

    }

    @Override
    public void remove(int id) {
        PRODUCT_MAP.remove(id);
    }
}