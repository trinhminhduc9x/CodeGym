package service.impl;

import service.IUserService;
import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean update(int id, User user) {
        return userRepository.update(id,user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> seachByCountry(String country) {
        return userRepository.searchByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public List<User> sortById() {
        return userRepository.sortByID();
    }

    @Override
    public User getUserById(int id) {
        return  userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }
}
