import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "productDiscountServlet", value = "/productDiscount")
public class ProductDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("mo_ta_san_pham");
        double listPrice = Double.parseDouble(request.getParameter("gia_niem_yet"));
        double discountPercent = Double.parseDouble(request.getParameter("ti_le_chiet_khau"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Discount.jsp");
        request.setAttribute("productDescription",productDescription);
        request.setAttribute("listPrice",listPrice);
        request.setAttribute("discountPercent",discountPercent);
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);

        requestDispatcher.forward(request,response);
    }
}
