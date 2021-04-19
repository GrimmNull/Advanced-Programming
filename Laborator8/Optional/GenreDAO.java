import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface GenreDAO {
    public static List<Genre> findAll(DBConnection myDB){
        List<Genre> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM movies");
        try {
            while(set.next())
                res.add(new Genre(set.getInt(1),set.getString(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static Genre findById(DBConnection myDB,int id){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM genres WHERE id=");
        temp.append(id);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Genre(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static Genre findByName(DBConnection myDB, String name){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM genres WHERE name='");
        temp.append(name);
        temp.append("'");
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Genre(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static void insertGenre(DBConnection myDB,Genre genre){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO genres (id, name) VALUES (");
        temp.append(genre.getId());
        temp.append(", '");
        temp.append(genre.getName());
        temp.append("')");
        myDB.queryTheDatabase(temp.toString());
    }

    public static void updateGenre(DBConnection myDB, Genre genre){
        StringBuilder temp=new StringBuilder();
        temp.append("UPDATE genres");
        temp.append("SET name='");
        temp.append(genre.getName());
        temp.append("' WHERE id=");
        temp.append(genre.getId());
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteGenre(DBConnection myDB, Genre genre){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM genres WHERE id=");
        temp.append(genre.getId());
        myDB.queryTheDatabase(temp.toString());
    }
}
