import models.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener()
public class LoadProductList implements ServletContextListener {

    public LoadProductList() {
    }

    public void contextInitialized(ServletContextEvent sce) {

        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Product("Mouse", "Sem fio", 1, 70.50));
        productList.add(new Product("Xiaomi Note 8", "Android, Tela 6.3", 2, 1400.20));
        productList.add(new Product("Playstation 5", "Video Game", 3, 7500.70));
        productList.add(new Product("Pen Drive", "Kingston 16GB", 1, 40.50));

        System.out.println("Contexto inicializado");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("global-product-list", productList);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
