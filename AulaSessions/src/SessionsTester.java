import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionsTester", urlPatterns = {"/SessionsTester"})
public class SessionsTester extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        há duas formas de pegar a sessão
//        uma vez que o getSession é sobrecarregado
//        usando o getSession(); a sessão é procurada, caso não encontrada uma nova sessão é criada
//        a outra forma é usar é colocar o parametro boleano false, que faz com que seja retornado ou a sessão
//        ou null, assim a sessão nova não é criada caso não exista
        HttpSession session = request.getSession();

        PrintWriter printer = response.getWriter();
        printer.println("<h1>SESSIONID: " + session.getId() + "</h1");
    }
}
