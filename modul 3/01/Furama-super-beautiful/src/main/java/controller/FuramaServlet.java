package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", value = "/Furama")
public class FuramaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "employee":
                goToEmployeePage(request,response);
                break;
            case "customer":
                goToCustomerPage(request,response);
                break;
            case "service":
                goToServicePage(request,response);
                break;
            case "contract":
                goToContractPage(request,response);
                break;
            default:
                goToHomePage(request,response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void goToHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }

    private void goToContractPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Contract").forward(request,response);
    }

    private void goToServicePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Facility");
        requestDispatcher.forward(request,response);
    }

    private void goToCustomerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Customer");
        requestDispatcher.forward(request,response);
    }

    private void goToEmployeePage(HttpServletRequest request, HttpServletResponse response) {
    }


}
