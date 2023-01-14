package repository.impl;

import jdk.nashorn.internal.ir.Assignment;
import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//" select* from users where id = 1;"
public class UserRepository implements IUserRepository {
    private final String QUERY_FIND_ALL = "call findAllUsers()";
    private final String QUERY_UPDATE = "call updateUser(?,?,?,?)";
    private final String QUERY_DELETE = "call deleteUser(?)";


    private final String INSERT_INTO = "insert into users (name,email,country) value(?,?,?)";
    private final String SELECT_BY_ID = "select* from users where id = ?";
    private static final String DELETE = "delete from users where id = ?;";
    private final String UPDATE_BY_ID = " update users set name = ?,email = ?,country = ? where id = ?";
    private final String SEARCH_BY_COUNTRY = "select * from users where country like ?";
    private final String SHORT_NAME = "select * from users order by name";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    @Override
    public List<User> findAll() {
       List<User>userList = new ArrayList<>();
       Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement =connection.prepareCall(QUERY_FIND_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean add(User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int check = preparedStatement.executeUpdate();
            return (check == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(QUERY_UPDATE);
            callableStatement.setInt(1,id);
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            int check = callableStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(QUERY_DELETE);
            callableStatement.setInt(1,id);
            int check = callableStatement.executeUpdate();
            return (check==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idRt = resultSet.getInt("id");
                String nameRt = resultSet.getString("name");
                String emailRt = resultSet.getString("email");
                String countryRt = resultSet.getString("country");
                user = new User(idRt, nameRt, emailRt, countryRt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryRt = resultSet.getString("country");
                User user = new User(id, name, email, countryRt);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHORT_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "call get_user_by_id(?)";
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) {
        String query = "call insert_user(?,?,?)";
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
//        Connection connection = null;
////        insert new user
//        PreparedStatement preparedStatement = null;
////        assign permision to user
//        PreparedStatement preparedStatement1 = null;
////        getting user id
//        ResultSet resultSet = null;
//
//        connection = BaseRepository.getConnectDB();
//        try {
//            connection.setAutoCommit(false);
//
////            insert user
//            preparedStatement = connection.prepareStatement(INSERT_INTO,Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2,user.getEmail());
//            preparedStatement.setString(3,user.getCountry());
//
//            int rowAffected = preparedStatement.executeUpdate();
//
////            get user id
//            resultSet = preparedStatement.getGeneratedKeys();
//            int userId = 0;
//            if (resultSet.next()){
//                userId = resultSet.getInt(1);
//
//            if (rowAffected==1) {
//                String sqlPivot = "insert into user_permision (user_id,permision_id)\n" +
//                        "value(?,?)";
//                preparedStatement1 = connection.prepareStatement(sqlPivot);
//                for (Integer permisionId:permision) {
//                    preparedStatement1.setInt(1,userId);
//                    preparedStatement1.setInt(2,permisionId);
//                    preparedStatement1.executeUpdate();
//                }
//                connection.commit();
//            } else {
//                connection.rollback();
//            }
//
//            }
//        } catch (SQLException e) {
//            try {
//                if (connection!=null){
//                    connection.rollback();
//                }
//            } catch (SQLException throwables) {
//                System.out.println(throwables.getMessage());
//            }
//            System.out.println(e.getMessage());
//        } finally {
//                try {
//                    if (resultSet!=null){
//                        resultSet.close();
//                    }
//                    if (preparedStatement != null){
//                        preparedStatement.close();
//                    }
//                    if (preparedStatement1 != null){
//                        preparedStatement1.close();
//                    }
//                    if (connection != null){
//                        connection.close();
//                    }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//        }


        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            conn = BaseRepository.getConnectDB();

            // set auto commit to false

            conn.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = conn.prepareStatement(INSERT_INTO, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permision to user

            //

            if (rowAffected == 1) {

                // assign permision to user

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permision) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (
                Connection connection = BaseRepository.getConnectDB();
                Statement statement = connection.createStatement();
                PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
                PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
        ) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String addUserTransaction1() {
        String message = "Success";
        Connection connection = BaseRepository.getConnectDB();

        try {
            connection.setAutoCommit(false);
//            hd1: Insert into table level
            PreparedStatement psInsertLevel = connection.prepareStatement("insert into level (id,name) value (?,?)");
            psInsertLevel.setInt(1,2);
            psInsertLevel.setString(2,"Master");
            int rowAffect = psInsertLevel.executeUpdate();
//            hd2: Insert into table Employee
            PreparedStatement psInsertEmployee = connection.prepareStatement("insert into employee1 (id,name,email,country) value(?,?,?,?)");
            psInsertEmployee.setInt(1,5);
            psInsertEmployee.setString(2,"Bon");
            psInsertEmployee.setString(3,"bubu");
            psInsertEmployee.setString(4,"Quang Tri");
            rowAffect += psInsertEmployee.executeUpdate();
            if (rowAffect==2){
                connection.commit();
            } else {
                message = "Fail";
                connection.rollback();
            }
        } catch (SQLException e) {
            message = "fail";
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return message;
    }
}
