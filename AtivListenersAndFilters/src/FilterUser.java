import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/user/*")
public class FilterUser implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest)req).getCookies();

        ServletContext context = req.getServletContext();
        ArrayList<String> contextTokens = (ArrayList<String>) context.getAttribute("tokens");

        // prevents null point exception
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("authentication")) {
                    if (contextTokens.contains(c.getValue())) {
                        chain.doFilter(req, resp);
                    }
                }
            }
        }
        ((HttpServletResponse)resp).sendRedirect("/AtivListenersAndFilters_war_exploded/login.html");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
