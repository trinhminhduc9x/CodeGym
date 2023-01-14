package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "update":
                showUpdateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("customer/updateCustomer.jsp").forward(request, response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("customer/createCustomer.jsp").forward(request, response);
    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, customerTypeId, name, dateOfBirth, gender, idCard,
                phoneNumber, email, address);
        Map<String, String> errors = customerService.check(customer);
        if (errors.isEmpty()) {
            customerService.updateCustomer(customer);
            response.sendRedirect("/customer");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("name", name);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("dateOfBirth", dateOfBirth);
            request.setAttribute("email", email);
            request.setAttribute("customer", customer);
            List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
            request.setAttribute("customerTypeList", customerTypeList);
            request.getRequestDispatcher("customer/updateCustomer.jsp").forward(request, response);
        }

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String customerTypeId = request.getParameter("customerTypeId");
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(Integer.parseInt(customerTypeId), name, dateOfBirth, gender,
                idCard, phoneNumber, email, address);
        Map<String, String> errors = customerService.check(customer);
        if (errors.isEmpty()) {
            customerService.insertCustomer(customer);
            response.sendRedirect("/customer");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("name", name);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("dateOfBirth", dateOfBirth);
            request.setAttribute("email", email);
            request.setAttribute("customer", customer);
            List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
            request.setAttribute("customerTypeList", customerTypeList);
            request.getRequestDispatcher("customer/createCustomer.jsp").forward(request, response);
        }

    }
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String keyName = request.getParameter("keyName");
        String keyAddress = request.getParameter("keyAddress");
        List<Customer> customerList = customerService.searchByName(keyName,keyAddress);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("keyName",keyName);
        request.setAttribute("keyAddress",keyAddress);
        request.setAttribute("customerList" ,customerList);
        request.setAttribute("customerTypeList",customerTypeList);
       request.getRequestDispatcher("customer/listCustomer.jsp").forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        customerService.deleteCustomer(Integer.parseInt(id));
        response.sendRedirect("/customer");
    }
}
