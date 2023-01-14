package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameForm = request.getParameter("username");
        String passForm = request.getParameter("password");
        String rememberMe =(request.getParameter("rememberMe"));
        User user = new User(usernameForm,passForm);
        // check tài khoản
        String mess ="Đăng nhập thất bại";
        // ví du check in thành công
        boolean check =true;
        if (check){
            mess ="Đăng nhập thành công";
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie cookieUser = new Cookie("username",usernameForm);
            Cookie cookiePassword = new Cookie("password",passForm);
            // remember me
            if (rememberMe!=null){
                cookieUser.setMaxAge(10000);
                cookiePassword.setMaxAge(10000);
            }else {
                cookieUser.setMaxAge(0);
                cookiePassword.setMaxAge(0);
            }
            response.addCookie(cookiePassword);
            response.addCookie(cookieUser);
        }
        request.setAttribute("mess",mess);
        request.getRequestDispatcher("view/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        for (Cookie c: cookies) {
            if (c.getName().equals("username")){
                username=c.getValue();
            }else if (c.getName().equals("password")){
                password=c.getValue();
            }
        }
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);

    }
}
