
import javax.persistence.*;

@Entity
public class acting {
    Integer id_actor;
    Integer id_movie;

    public Integer getIdActor() {
        return id_actor;
    }

    public void setIdActor(Integer idActor) {
        this.id_actor = idActor;
    }

    public Integer getIdMovie() {
        return id_movie;
    }

    public void setIdMovie(Integer idMovie) {
        this.id_movie = idMovie;
    }
}
