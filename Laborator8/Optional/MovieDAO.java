import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public interface MovieDAO {
    public static List<Movie> findAll(DBConnection myDB){
        List<Movie> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM movies");
        try {
            while(set.next())
                res.add(new Movie(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static Movie findById(DBConnection myDB,int id){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM movies WHERE id=");
        temp.append(id);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Movie(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5));
            }
         }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static Movie findByName(DBConnection myDB, String name){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM movies WHERE name='");
        temp.append(name);
        temp.append("'");
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Movie(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static void insertMovie(DBConnection myDB,Movie movie){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO movies (id, title, release_date, durata, score) VALUES (");
        temp.append(movie.getId());
        temp.append(", '");
        temp.append(movie.getTitle());
        temp.append("', '");
        temp.append(movie.getReleaseDate());
        temp.append("', ");
        temp.append(movie.getDurata());
        temp.append(", ");
        temp.append(movie.getScore());
        temp.append(")");
        myDB.queryTheDatabase(temp.toString());
    }

    public static void updateMovie(DBConnection myDB, Movie movie){
        StringBuilder temp=new StringBuilder();
        temp.append("UPDATE movies");
        temp.append(" SET title='");
        temp.append(movie.getTitle());
        temp.append("', release_date='");
        temp.append(movie.getReleaseDate());
        temp.append("', durata=");
        temp.append(movie.getDurata());
        temp.append(", score=");
        temp.append(movie.getScore());
        temp.append(" WHERE id=");
        temp.append(movie.getId());
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteMovie(DBConnection myDB, Movie movie){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM movies WHERE id=");
        temp.append(movie.getId());
        myDB.queryTheDatabase(temp.toString());
    }
}
