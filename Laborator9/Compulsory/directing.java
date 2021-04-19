import javax.persistence.*;

@Entity
public class directing {
    Integer id_director;
    Integer id_movie;



    public Integer getIdDirector() {
        return id_director;
    }

    public void setIdDirector(Integer idDirector) {
        this.id_director = idDirector;
    }

    public Integer getIdMovie() {
        return id_movie;
    }

    public void setIdMovie(Integer idMovie) {
        this.id_movie = idMovie;
    }
}
