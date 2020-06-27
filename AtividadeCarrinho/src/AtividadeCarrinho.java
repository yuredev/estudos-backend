import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AtividadeCarrinho", urlPatterns = "/Carrinho")
public class AtividadeCarrinho extends HttpServlet {

    ArrayList<Product> products;

    public AtividadeCarrinho() {
        products = new ArrayList<>();
        products.add(new Product("Celular Moto G5s", "Celular android", 1, 700.0));
        products.add(new Product("Livro The Hobbit", "Livro de fantasia", 2, 60.70));
        products.add(new Product("Livro JavaScript on Things", "Livro técnico", 3, 100.0));
        products.add(new Product("Tênis Nike Air Max", "Tênis", 4, 350.35));
        products.add(new Product("Violão Tagima Woodstock TW29", "Violão de cordas de aço", 5, 650.50));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer productId = Integer.parseInt(request.getParameter("id"));

        ArrayList<Product> sessionProducts = (ArrayList<Product>) session.getAttribute("products");
        if (sessionProducts == null) {
            sessionProducts = new ArrayList<Product>();
        }

        for (Product p : products) {
            if (p.getId().equals(productId)) {
                sessionProducts.add(p);
                session.setAttribute("products", sessionProducts);
                break;
            }
        }
        // 3 minutos pq abaixo é em segundos
        session.setMaxInactiveInterval(180); // seta tempo maximo de inatividade para destruir sessão

        // é possível tambem setar o tempo maximo de inatividade
        // dentro do web.xml que lá conta em minutos

        response.setContentType("text/html");
        if (sessionProducts.isEmpty()) {
            response.getWriter().println("Carrinho vazio");
        } else {
            for (Product p : sessionProducts) {
                response.getWriter().println("<h1>" +p.getName()+"</h2>");
            }
        }
    }
}
