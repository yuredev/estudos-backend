import models.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/TablePref"})
public class TablePref extends HttpServlet {

    private ArrayList<String> registers;

    public TablePref() {
        this.registers = new ArrayList<String>();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String[] prefs = request.getParameterValues("preferences");

        People p = new People(name, age, prefs);

        System.out.println(p);

        String html;

        String templatePrefs = "";

        for (String pref: prefs) {
            templatePrefs += "<div>" + pref + "</div>";
        }

        this.registers.add(
            "<tr>" +
                "<td>" +
                    p.getName() +
                "</td>" +
                "<td>" +
                    p.getAge() +
                "</td>" +
                "<td>" +
                    templatePrefs +
                "</td>" +
            "</tr>"
        );

        templatePrefs = "";
        for (String reg :registers) {
            templatePrefs += reg;
        }

        html = "<html>" +
                "<head>" +
                    "<style>" +
                        "table {width: 200px; border-collapse: collapse;}" +
                        "table, tr, td, th {" +
                            "border-color: black;" +
                            "border-width: 1px;" +
                            "border-style: solid;" +
                            "border-radius: 5px;" +
                        "}" +
                    "</style>" +
                "</head>" +
                "<body>" +
                    "<table>" +
                        "<tr>" +
                            "<th>" +
                                "name" +
                            "</th>" +
                            "<th>" +
                                "age" +
                            "</th>" +
                            "<th>" +
                                "preferences" +
                            "</th>" +
                        "</tr>" +
                       templatePrefs +
                    "</table>" +
                "</body>" +
            "</html>";

        response.getWriter().println(html);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}