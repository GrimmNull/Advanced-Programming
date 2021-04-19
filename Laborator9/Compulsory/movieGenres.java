import javax.persistence.*;

@Entity
public class movieGenres {
    private Integer id_movie;
    private Integer id_genre;

    public Integer getIdMovie() {
        return id_movie;
    }

    public void setIdMovie(Integer idMovie) {
        this.id_movie = idMovie;
    }

    public Integer getIdGenre() {
        return id_genre;
    }

    public void setIdGenre(Integer idGenre) {
        this.id_genre = idGenre;
    }
}
