import models.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReadList", urlPatterns = "/ReadList")
public class ReadList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sce = getServletContext();

        @SuppressWarnings("unchecked") // tava dando warning, coloquei isso pra tirar
        ArrayList<Product> productList = (ArrayList<Product>) sce.getAttribute("global-product-list");

        for (Product p : productList) {
            response.getWriter().println(p.getName());
        }
    }
}
