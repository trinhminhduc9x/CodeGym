package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
