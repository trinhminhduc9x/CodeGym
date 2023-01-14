package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    boolean add(User user);
    boolean update(int id, User user);
    boolean delete(int id);
    User findById(int id);
    List<User> searchByCountry(String country);
    List<User>sortByName();
    User getUserById(int id);
    void insertUserStore(User user);
    void addUserTransaction(User user, int[] permision);
    void insertUpdateWithoutTransaction();

    String addUserTransaction1();
}
