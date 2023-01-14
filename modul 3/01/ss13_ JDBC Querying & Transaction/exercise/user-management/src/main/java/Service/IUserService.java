package Service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean add(User user);
    boolean update(int id, User user);
    boolean delete(int id);
    User findById(int id);
    List<User>seachByCountry(String coutry);
    List<User>sortByName();
    User getUserById(int id);
    void insertUserStore(User user);
    void  addUserTransaction(User user,int[] permision);//thực hành ss13
    String  addUserTransaction1();//Bài tập ss13
    void insertUpdateWithoutTransaction();
}
