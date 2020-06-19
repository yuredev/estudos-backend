import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//WebServlet define as rotas para o servlet
@WebServlet(urlPatterns = {"/Ciclo"}, initParams = {
    @WebInitParam(name = "empresa", value = "ufrn")
})
public class CicloVida extends HttpServlet {


    // um servlet tem ciclos de vida
    // o ciclo é
    // construtor
    // init
    // service

    // o service é um loop
    // no qual ele é encarregado de chamar os outros métodos
    // como post, get, put etc.
    // logo quando o post, get, delete é finalizado
    // a execução volta pro service

    // o destroy só é chamado quando o servidor é finalizado


    public CicloVida() {
        System.out.println("Construtor");
    }

//    o método init inicializa as variaveis de inicialização
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");

        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        var servletConfig = getServletConfig();
        var admin = servletConfig.getInitParameter("admin");
//        versões mais novas do Java possuem o var que funciona por inferencia assim como no Dart
        var name = request.getParameter("name");
        var empresa = servletConfig.getInitParameter("empresa");
        System.out.println(name + " received");
        response.getWriter().println("Hello " + name + " admin: " + admin + " empresa: " + empresa);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
