import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/auth")
public class Authenticate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        ArrayList<User> userList = (ArrayList<User>) getServletContext().getAttribute("users");

        boolean userWasFound = false;

        for (User u: userList) {
            if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
                userWasFound = true;
                break;
            }
        }
        if (userWasFound) {
            String token = email + password;
            ServletContext context = getServletContext();

            ArrayList<String> tokens = (ArrayList<String>) context.getAttribute("tokens");
            tokens.add(token);
            context.setAttribute("tokens", tokens);

            response.addCookie(new Cookie("authentication", token));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/user/hello.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
            dispatcher.forward(request, response);
        }
    }
}
