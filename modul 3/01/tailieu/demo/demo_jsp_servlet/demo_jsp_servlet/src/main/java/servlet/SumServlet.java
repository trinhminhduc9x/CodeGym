package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("n1"));
        int num2 = Integer.parseInt(request.getParameter("n2"));
        int sum = num1+num2;
        // cách 2 ok => nên dùng
        request.setAttribute("tong",sum);
        request.getRequestDispatcher("/result.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int num1 = Integer.parseInt(request.getParameter("n1"));
//        int num2 = Integer.parseInt(request.getParameter("n2"));
//        int sum = num1+num2;
//        // cách 1 củ chuối không dùng
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<button>Click</button>");
//        printWriter.print("<h1> tong cua 2 so la: "+sum+"</h1>");
    }
}
