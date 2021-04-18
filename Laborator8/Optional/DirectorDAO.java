import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface DirectorDAO {
    public static List<Director> findAll(DBConnection myDB){
        List<Director> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM director");
        try {
            while(set.next())
                res.add(new Director(set.getInt(1),set.getString(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static Director findById(DBConnection myDB,int id){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM director WHERE id=");
        temp.append(id);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(!set.isBeforeFirst())
                return null;
            else
            return new Director(set.getInt(1),set.getString(2));
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static Director findByName(DBConnection myDB, String name){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM director WHERE name=");
        temp.append(name);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(!set.isBeforeFirst())
                return null;
            else
            return new Director(set.getInt(1),set.getString(2));
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static void insertDirector(DBConnection myDB,Director director){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO director (id, name) VALUES (");
        temp.append(director.getId());
        temp.append(", '");
        temp.append(director.getName());
        temp.append("')");
        myDB.queryTheDatabase(temp.toString());
    }

    public static void updateDirector(DBConnection myDB, Director director){
        StringBuilder temp=new StringBuilder();
        temp.append("UPDATE director");
        temp.append("SET name='");
        temp.append(director.getName());
        temp.append("' WHERE id=");
        temp.append(director.getId());
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deleteDirector(DBConnection myDB, Director director){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM director WHERE id=");
        temp.append(director.getId());
        myDB.queryTheDatabase(temp.toString());
    }
}
