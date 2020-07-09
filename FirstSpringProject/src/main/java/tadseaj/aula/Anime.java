package tadseaj.aula;

// construtor com todos os argumentos
import lombok.AllArgsConstructor;

// gerar construtor vazio
import lombok.NoArgsConstructor;

//gerar gets e sets automaticamente
import lombok.Data;

// para indicar que a classe será o modelo
// de uma entidade do banco de dados
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String category;
    String description;
    Integer releaseYear;
}
