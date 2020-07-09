package tadseaj.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AnimeController {

    @Autowired
    AnimeService animeService;

    @RequestMapping("/")
    public String getHome(Model model) {
        return "index";
    }
}
