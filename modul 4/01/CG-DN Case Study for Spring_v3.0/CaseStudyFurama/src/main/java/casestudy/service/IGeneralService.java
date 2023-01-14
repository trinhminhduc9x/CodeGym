package casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findListAll();

    List<T> findListById(Integer id);

    void save(T t);

    T findById(Integer id);

    void update(T t);

    void remove(Integer id);

    Page<T> findPageNameAll(Pageable pageable, String name);
}