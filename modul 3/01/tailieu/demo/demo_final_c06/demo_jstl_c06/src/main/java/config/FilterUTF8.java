package config;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterUTF8",value = "/*")
public class FilterUTF8 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpSession session= request.getSession();
//        User user =(User)session.getAttribute("user");
//        String url = request.getRequestURI();
//        System.out.println(url);
//
//        if (user!=null||url.equals("/login")){
            chain.doFilter(req, resp);
//        } else {
//            System.out.println("chưa đăng nhập");
//            request.getRequestDispatcher("view/login.jsp").forward(request,resp);
//        }

    }


}
