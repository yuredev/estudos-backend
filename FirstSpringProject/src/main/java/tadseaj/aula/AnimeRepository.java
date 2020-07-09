package tadseaj.aula;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByDescription(String description);
    List<Anime> findByReleaseYear(Integer releaseYear);
}
