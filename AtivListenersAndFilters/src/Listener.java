import models.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class Listener implements ServletContextListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User("Goku", "goku@gmail.com", "goku123", 1));
        userList.add(new User("Luffy", "luffy@gmail.com", "luffy123", 2));
        userList.add(new User("Eren", "eren@gmail.com", "eren123", 3));
        userList.add(new User("Saitama", "saitama@gmail.com", "saitama123", 4));

        sce.getServletContext().setAttribute("tokens", new ArrayList<String>());
        sce.getServletContext().setAttribute("users", userList);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
