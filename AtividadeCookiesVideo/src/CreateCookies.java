import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CreateCookies", urlPatterns = "/CreateCookies")
public class CreateCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cookie> cookies = new ArrayList<>();

        cookies.add(new Cookie("coxinha", "de_frango"));
        cookies.add(new Cookie("pastel", "misto"));
        cookies.add(new Cookie("queijada", "de_queijo_ne"));
        cookies.add(new Cookie("enroladinho", "Salsicha"));
        cookies.add(new Cookie("empada", "frango"));

        cookies.get(0).setMaxAge(30 * 60); // coxinha
        cookies.get(1).setMaxAge(30 * 60); // pastel

        for (Cookie c: cookies) {
            response.addCookie(c);
        }
    }
}
