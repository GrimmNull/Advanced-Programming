public class MovieGenres {
    private Integer idMovie;
    private Integer idGenre;

    public MovieGenres(Integer idMovie, Integer idGenre) {
        this.idMovie = idMovie;
        this.idGenre = idGenre;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }
}
