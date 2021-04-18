import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MovieGenresDAO {
    public static List<MovieGenres> findAll(DBConnection myDB){
        List<MovieGenres> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM movieGenres");
        try {
            while(set.next())
                res.add(new MovieGenres(set.getInt(1),set.getInt(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static void insertMovieGenre(DBConnection myDB,MovieGenres genre){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO movieGenres (id_movie, id_genre) VALUES (");
        temp.append(genre.getIdMovie());
        temp.append(", ");
        temp.append(genre.getIdGenre());
        temp.append(")");
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteMovieGenre(DBConnection myDB, MovieGenres genre){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM movieGenres WHERE id_movie=");
        temp.append(genre.getIdMovie());
        temp.append(" AND id_genre=");
        temp.append(genre.getIdGenre());
        myDB.queryTheDatabase(temp.toString());
    }
}
