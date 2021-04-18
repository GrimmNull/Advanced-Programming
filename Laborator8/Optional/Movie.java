public class Movie {
    private Integer id;
    private String title;
    private String releaseDate;
    private Integer durata;
    private Integer score;

    public Movie(Integer id, String title, String release_date, Integer durata, Integer score) {
        this.id = id;
        this.title = title;
        this.releaseDate = release_date;
        this.durata = durata;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", durata=" + durata +
                ", score=" + score +
                '}';
    }
}
