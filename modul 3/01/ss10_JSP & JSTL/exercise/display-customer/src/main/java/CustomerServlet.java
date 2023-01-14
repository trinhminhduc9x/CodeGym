import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer>customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
     customerList.add(new Customer(1,"duc", LocalDate.parse("1999-09-11"),"da nang"));
     customerList.add(new Customer(2,"duc", LocalDate.parse("1999-09-11"),"da nang"));
     customerList.add(new Customer(3,"duc", LocalDate.parse("1999-09-11"),"da nang"));
     customerList.add(new Customer(4,"duc", LocalDate.parse("1999-09-11"),"da nang"));
     customerList.add(new Customer(5,"duc", LocalDate.parse("1999-09-11"),"da nang"));
     customerList.add(new Customer(6,"duc", LocalDate.parse("1999-09-11"),"da nang"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/list.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
