package repository;

import model.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
}
