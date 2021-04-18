import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DirectingDAO {
    public static List<Directing> findAll(DBConnection myDB){
        List<Directing> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM directing");
        try {
            while(set.next())
                res.add(new Directing(set.getInt(1),set.getInt(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static void insertDirecting(DBConnection myDB,Directing genre){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO directing (id_director, id_movie) VALUES (");
        temp.append(genre.getIdDirector());
        temp.append(", ");
        temp.append(genre.getIdMovie());
        temp.append(")");
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteDirecting(DBConnection myDB, Directing genre){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM directing WHERE id_director=");
        temp.append(genre.getIdDirector());
        temp.append(" AND id_movie=");
        temp.append(genre.getIdMovie());
        myDB.queryTheDatabase(temp.toString());
    }
}
