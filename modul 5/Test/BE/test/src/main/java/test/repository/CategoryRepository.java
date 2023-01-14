package test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.dto.CategoryView;
import test.model.Category;

import javax.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select c.id," +
            "c.name tenSanPham," +
            "p.price giaTien," +
            "s.price_number donVi," +
            "c.number soLuong," +
            "c.product_day ngayNhap," +
            "c.start_day ngaySanXuat," +
            "c.end_day ngayHetHan," +
            "from category c " +
            "join product p on c.product_id = p.id",
            countQuery = "select c.id," +
                    "c.name tenSanPham," +
                    "p.price giaTien," +
                    "s.price_number donVi," +
                    "c.number soLuong," +
                    "c.product_day ngayNhap," +
                    "c.start_day ngaySanXuat," +
                    "c.end_day ngayHetHan," +
                    "from category c " +
                    "join product p on c.product_id = p.id" +
                    "where product.product_name like %:nameSearch% " +
                    "and repo.repo_date_in like %:dateInSearch% " +
                    "and repo.repo_date_end like %:dateEndSearch% "
                    ,nativeQuery=true)
    Page<CategoryView> search(@Param("nameSearch") String nameSearch,
                                  @Param("dateInSearch") String dateInSearch,
                                  @Param("dateEndSearch") String dateEndSearch,
                                  Pageable pageable);




}
