package controller;

import service.IUserService;
import service.impl.UserService;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns ={"","/User"})
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddUser(request,response);
                break;
            case "update":
                showUpdateUser(request,response);
                break;
            case "delete":
                deleteUsers(request,response);
                break;
            case "sortName":
                sortUser(request,response);
                break;
            case "sortId":
                sortUserId(request,response);
                break;
            case "permision":
                addUserPermision(request,response);
                break;
            case "test-without-tran":
                textWithoutTran(request,response);
            case "test-use-tran":
                testUseTran(request, response);
                break;
            default:
                showListUser(request, response);
        }
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateUseTransaction();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addUser(request,response);
                break;
            case "update":
                updateUser(request,response);
                break;
            case "search":
                searchId(request,response);
            default:
                showListUser(request, response);
        }
    }

    private void textWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permision = {1,2,4};
        userService.addUserTransaction(user,permision);
        showListUser(request,response);
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response) {
        List<User>userList=userService.sortByName();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        request.setAttribute("userList",userList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User>userList=userService.seachByCountry(country);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        if (userList.isEmpty()){
            request.setAttribute("message","Not found");
        } else {
            request.setAttribute("userList",userList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/update.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
//        User user = userService.getUserById(id);
        if (user == null){
            request.setAttribute("message","Not Found");
        } else {
            request.setAttribute("user",user);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteUsers(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        showListUser(request,response);
    }

    private void showAddUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/add.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        if (userService.update(id,user)){
            request.setAttribute("message","Success");
        } else {
            request.setAttribute("message","Success");
        }
        showListUser(request,response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        if (userService.add(user)){
            request.setAttribute("message", "Success");
        } else {
            request.setAttribute("message","Fail");
        }
        showAddUser(request,response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        List<User>userList = userService.findAll();
        request.setAttribute("userList",userList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchId(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        List<User>userList= new ArrayList<>();
        userList.add(userService.findById(Integer.parseInt(id)));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        if (userList.isEmpty()){
            request.setAttribute("message","Not found");
        } else {
            request.setAttribute("userList",userList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sortUserId(HttpServletRequest request, HttpServletResponse response) {
        List<User>userList=userService.sortById();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        request.setAttribute("userList",userList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
