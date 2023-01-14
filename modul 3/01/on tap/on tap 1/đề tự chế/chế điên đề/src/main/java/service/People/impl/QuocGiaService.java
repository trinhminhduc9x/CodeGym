package service.People.impl;

import model.people.QuocGia;
import repository.people.IDoTuoiRepository;
import repository.people.IQuocGiaRepository;
import repository.people.impl.DoTuoiRepository;
import repository.people.impl.QuocGiaRepository;
import service.People.IQuocGiaService;

import java.util.List;

public class QuocGiaService implements IQuocGiaService {
    private IQuocGiaRepository quocGiaRepository = new QuocGiaRepository();
    @Override
    public List<QuocGia> FindAll() {
        return quocGiaRepository.FindAll();
    }

    @Override
    public boolean addCustomerType(QuocGia customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(QuocGia customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public QuocGia findById(int id) {
        return null;
    }
}
