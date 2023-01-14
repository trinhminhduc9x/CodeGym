package service.impl;

import model.ClassCG;
import repository.IClassRepository;
import repository.impl.ClassRepository;
import service.IClassService;

import java.util.List;

public class ClassService  implements IClassService {
    IClassRepository classRepository= new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }
}
