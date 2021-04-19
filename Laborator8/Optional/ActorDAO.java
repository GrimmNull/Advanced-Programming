import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface ActorDAO {
    public static List<Actor> findAll(DBConnection myDB){
        List<Actor> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM actor");
        try {
            while(set.next())
                res.add(new Actor(set.getInt(1),set.getString(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static Actor findById(DBConnection myDB,int id){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM actor WHERE id=");
        temp.append(id);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Actor(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static Actor findByName(DBConnection myDB, String name){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM actor WHERE name='");
        temp.append(name);
        temp.append("'");
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Actor(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static void insertActor(DBConnection myDB,Actor actor){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO actor (id, name) VALUES (");
        temp.append(actor.getId());
        temp.append(", '");
        temp.append(actor.getName());
        temp.append("')");
        myDB.queryTheDatabase(temp.toString());
    }

    public static void updateActor(DBConnection myDB, Actor actor){
        StringBuilder temp=new StringBuilder();
        temp.append("UPDATE actor");
        temp.append("SET name='");
        temp.append(actor.getName());
        temp.append("' WHERE id=");
        temp.append(actor.getId());
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteActor(DBConnection myDB, Actor actor){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM actor WHERE id=");
        temp.append(actor.getId());
        myDB.queryTheDatabase(temp.toString());
    }
}
