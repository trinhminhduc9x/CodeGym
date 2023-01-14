package controller;

import model.people.*;
import service.People.*;
import service.People.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/Home")
public class CustomerServlet extends HttpServlet {
    IPhimService phimService = new PhimService();
    ITheLoaiService theLoaiService=  new TheLoaiService();
    IQuocGiaService quocGiaService=  new QuocGiaService();
    IDoTuoiService doTuoiService=  new DoTuoiService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "addCustomer":
               // showAddCustomer(request,response);
                break;
            case "updateCustomer":
               // showUpdateCustomer(request,response);
                break;
            default:
                showListCustomer(request,response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
//        switch (action){
//            case "addCustomer":
//                addCustomer(request,response);
//                break;
//            case "updateCustomer":
//                updateCustomer(request,response);
//                break;
//            case "deleteCustomer":
//                deleteCustomer(request,response);
//                break;
//            case "searchCustomer":
//                showListSearch(request,response);
//            default:
//                showListCustomer(request,response);
//
//        }
    }
//    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
//        String customerTypeId = request.getParameter("customerTypeId");
//        List<Customer>customerList = customerList.searchCustomer(name,phone,email,customerTypeId);
//        List<CustomerType>customerTypeList = customerTypeService.FindAll();
//        request.setAttribute("customerList",customerList);
//        request.setAttribute("customerTypeList",customerTypeList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
//        requestDispatcher.forward(request,response);
//    }



//    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("idUpdate"));
//        Customer customer = customerService.findById(id);
//        List<CustomerType> customerTypeList = customerTypeService.FindAll();
//        if (customer==null){
//            request.setAttribute("message","Không tìm thấy sản phẩm có id đã chọn");
//        } else {
//            request.setAttribute("customer",customer);
//        }
//        request.setAttribute("customerTypeList",customerTypeList);
//        request.getRequestDispatcher("view/customer/update.jsp").forward(request,response);
//    }

//    private void showAddCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/add.jsp");
//        List <CustomerType>customerTypeList = customerTypeService.FindAll();
//        request.setAttribute("customerTypeList",customerTypeList);
//        requestDispatcher.forward(request,response);
//    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Phim>phimList = phimService.FindAll();
        List<TheLoai>theLoaiList = theLoaiService.FindAll();
        List<QuocGia>quocGiaList = quocGiaService.FindAll();
        List<DoTuoi>doTuoiList = doTuoiService.FindAll();

        if (phimList.isEmpty()){
            request.setAttribute("message","Chưa có dữ liệu khách hàng");
        } else {
            request.setAttribute("phimList",phimList);
        }
        request.setAttribute("theLoaiList",theLoaiList);
        request.setAttribute("quocGiaList",quocGiaList);
        request.setAttribute("doTuoiList",doTuoiList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        requestDispatcher.forward(request,response);
    }



//    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        customerService.deleteCustomer(id);
//        showListCustomer(request,response);
//    }

//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        int customerTypeId = Integer.parseInt(request.getParameter("customerType"));
//        String name = request.getParameter("name");
//        String dateOfBirth =request.getParameter("dayOfBirth");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
//        String idCard = request.getParameter("idCard");
//        String phoneNumber=request.getParameter("phone");
//        String email =request.getParameter("email");
//        String address=request.getParameter("address");
//        Customer customer = new Customer(id,customerTypeId,name,dateOfBirth,gender,idCard,phoneNumber,email,address);
//        Map<String,String>errorList = customerService.checkValidateCustomer(customer);
//        if (errorList.isEmpty()){
//            customerService.updateCustomer(customer);
//            showListCustomer(request,response);
//        } else {
//            request.setAttribute("errorList",errorList);
//            request.setAttribute("customer",customer);
//        }
//        boolean check = false;
//        if (customerService.updateCustomer(customer)) {
//            check = true;
//        }
//        request.setAttribute("check",check);
//        List<CustomerType> customerTypeList = customerTypeService.FindAll();
//        request.setAttribute("customer",customer);
//        request.getRequestDispatcher("view/customer/update.jsp").forward(request,response);
//    }

//    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         int customerTypeId = Integer.parseInt(request.getParameter("customerType"));
//         String name = request.getParameter("name");
//         String dateOfBirth =request.getParameter("dayOfBirth");
//         boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
//         String idCard = request.getParameter("idCard");
//         String phoneNumber=request.getParameter("phone");
//         String email =request.getParameter("email");
//         String address=request.getParameter("address");
//         Customer customer = new Customer(customerTypeId,name,dateOfBirth,gender,idCard,phoneNumber,email,address);
//        Map<String,String>errorList=customerService.checkValidateCustomer(customer);
//        if (errorList.isEmpty()) {
//            boolean check = customerService.addCustomer(customer);
//            showListCustomer(request,response);
//        } else {
//            request.setAttribute("errorList",errorList);
//            request.setAttribute("customer",customer);
//            List<CustomerType>customerTypeList = customerTypeService.FindAll();
//            request.setAttribute("customerTypeList",customerTypeList);
//            request.getRequestDispatcher("view/customer/add.jsp").forward(request,response);
//        }
//
//
//
//    }
}
