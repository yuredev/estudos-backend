import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        boolean isAuth = false;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("authentication")) {
                    isAuth = true;
                    break;
                }
            }
        }
        if (isAuth) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse)resp).sendRedirect("https://pt.stackoverflow.com/search?q=why%20header%20is%20null");
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }
}
