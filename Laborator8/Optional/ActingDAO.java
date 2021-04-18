import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ActingDAO {
    public static List<Acting> findAll(DBConnection myDB){
        List<Acting> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM acting");
        try {
            while(set.next())
                res.add(new Acting(set.getInt(1),set.getInt(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static void insertActing(DBConnection myDB,Acting acting){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO acting (id_actor, id_movie) VALUES (");
        temp.append(acting.getIdActor());
        temp.append(", ");
        temp.append(acting.getIdMovie());
        temp.append(")");
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteActing(DBConnection myDB, Acting acting){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM acting WHERE id_actor=");
        temp.append(acting.getIdActor());
        temp.append(" AND id_movie=");
        temp.append(acting.getIdMovie());
        myDB.queryTheDatabase(temp.toString());
    }
}
