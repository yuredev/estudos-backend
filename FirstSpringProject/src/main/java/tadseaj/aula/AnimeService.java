package tadseaj.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    @Autowired
    AnimeRepository animeRepo;

    public List<Anime> findAll() {
        return animeRepo.findAll();
    }
}
