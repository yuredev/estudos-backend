import models.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletHello", urlPatterns = {"/Hello"})
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("Hello");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("authentication")) {
                    response.getWriter().println("CONTEXT TOKENS: " + getServletContext().getAttribute("tokens"));
                    response.getWriter().println("COOKIE AUTHENTICATION: " + c.getValue());
                    break;
                }
            }
        }
    }
}
