import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/ReadCookies")
public class ReadCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
//      prevents null point exception
        if (cookies != null) {
            for (Cookie c : cookies) {
                response.getWriter().println(c.getName() + ": " + c.getValue());
            }
        } else {
            response.getWriter().println("Nenhum cookie encontrado");
        }
    }
}
