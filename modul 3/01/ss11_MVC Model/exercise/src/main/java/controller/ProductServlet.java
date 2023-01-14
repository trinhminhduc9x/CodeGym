package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns ={"", "/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action) {
            case "add":
                showAddProduct(request,response);
                break;
            case "update":
                showUpdateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
//            case "view":
//                showViewProduct(request,response);
//                break;
            default:
                showListProduce(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action) {
            case "add":
                addProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;

            case "search":
                searchProduct(request,response);
                break;
            default:
        }
    }

//    private void showViewProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.findById(id);
//        request.setAttribute("product",product);
//        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/product/view.jsp") ;
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher= request.getRequestDispatcher("error404.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher= request.getRequestDispatcher("view/product/delete.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher= request.getRequestDispatcher("error404.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher= request.getRequestDispatcher("view/product/update.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/add.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduce(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        List<Product>productList=productService.findAll();
        request.setAttribute("productList",productList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        String name = request.getParameter("name");
        List<Product>productList = productService.searchByName(name);
        if (productList.isEmpty()){
            request.setAttribute("message","Không có sản phẩm bạn muốn tìm");
        } else {
            request.setAttribute("productList",productList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        Product product = new Product(id,name,price,description,producer);
        productService.update(id,product);
        showListProduce(request,response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random()*10000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        Product product = new Product(id,name,price,description,producer);
        productService.add(product);
        request.setAttribute("message","Đã thêm mới thành công");
        showAddProduct(request,response);

    }
}
