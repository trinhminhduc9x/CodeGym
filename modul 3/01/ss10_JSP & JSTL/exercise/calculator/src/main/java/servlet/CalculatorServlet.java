package servlet;

import service.CalcutatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/Calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble (request.getParameter("first_operand"));
        double num2 = Double.parseDouble (request.getParameter("second_operand"));
        String operator = request.getParameter("Operator");

        CalcutatorService calculato = new CalcutatorService ();
        String result = calculato.calculate(num1, num2, operator);
        request.setAttribute("num1",num1);
        request.setAttribute("num2",num2);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);

        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
