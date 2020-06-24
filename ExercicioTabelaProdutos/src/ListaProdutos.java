import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "ListaProdutos", urlPatterns = {"/List"})
public class ListaProdutos extends HttpServlet {

    ArrayList<Product> products;

    public ListaProdutos() {
        products = new ArrayList();
        products.add(new Product("Moto G5s", "Android cellphone", 5434, 700.0));
        products.add(new Product("The Hobbit", "Book", 4004, 60.70));
        products.add(new Product("JavaScript on Things", "Book", 9000, 100.0));
        products.add(new Product("Nike Air Max", "Sneakers", 1000, 350.35));
        products.add(new Product("Tagima Woodstock TW29", "Guitar", 2012, 650.50));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String transformInTemplate(Product p) {
        String productsTemplate = "";
        productsTemplate += "<tr>";
        productsTemplate += "<td>";
        productsTemplate += p.getName();
        productsTemplate += "</td>";
        productsTemplate += "<td>";
        productsTemplate += p.getDecription();
        productsTemplate += "</td>";
        productsTemplate += "<td>";
        productsTemplate += p.getId();
        productsTemplate += "</td>";
        productsTemplate += "<td>";
        productsTemplate += p.getPrice();
        productsTemplate += "</td>";
        productsTemplate += "<td>";
        productsTemplate += "<a href=\"/ExercicioTabelaProdutos_war_exploded/ShoppingCart?id="+p.getId()+"\">Add " + p.getName() + "</a>";
        productsTemplate += "</td>";
        productsTemplate += "</tr>";
        return productsTemplate;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productsTemplate = "";
        for (Product p : products) {
            productsTemplate += this.transformInTemplate(p);
        }

        String template =
                "<head><style>table {width: 200px; border-collapse: collapse;}table, tr, td, th {border-color: black;border-width: 1px;border-style: solid;border-radius: 5px;padding:5px;}</style></head>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>" +
                "name" +
                "</th>" +
                "<th>" +
                "description" +
                "</th>" +
                "<th>" +
                "id" +
                "</th>" +
                "<th>" +
                "price" +
                "</th>" +
                        "<th>" +
                        "product link" +
                        "</th>" +
                "</tr>" +
                productsTemplate +
                "</table>" +
                "</body>";
        response.setContentType("text/html");
        response.getWriter().println(template);
    }
}
