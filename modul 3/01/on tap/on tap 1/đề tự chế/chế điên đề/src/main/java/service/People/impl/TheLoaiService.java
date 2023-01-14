package service.People.impl;

import model.people.TheLoai;
import repository.people.IQuocGiaRepository;
import repository.people.ITheLoaiRepository;
import repository.people.impl.QuocGiaRepository;
import repository.people.impl.TheLoaiRepository;
import service.People.ITheLoaiService;

import java.util.List;

public class TheLoaiService implements ITheLoaiService {
    private ITheLoaiRepository theLoaiRepository = new TheLoaiRepository();
    @Override
    public List<TheLoai> FindAll() {
        return theLoaiRepository.FindAll();
    }

    @Override
    public boolean addCustomerType(TheLoai customerType) {
        return false;
    }

    @Override
    public boolean updateCustomerType(TheLoai customerType) {
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return false;
    }

    @Override
    public TheLoai findById(int id) {
        return null;
    }
}
