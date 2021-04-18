import java.sql.*;
import java.util.Arrays;
import java.util.Locale;

public class DBConnection {
    private Statement stmt;
    private ResultSet result;
    private Connection con;
    private String lastTable;
    private static DBConnection dbConn=null;
    private DBConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){ System.out.println(e);}
    }
    public static DBConnection getConnection(){
        if(dbConn==null)
            dbConn=new DBConnection();
        return dbConn;
    }
    public ResultSet queryTheDatabase(String stm){
        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "student", "STUDENT");
            stmt=con.createStatement();
            result=stmt.executeQuery(stm);
            if(stm.toUpperCase().contains("SELECT")){
                String[] temp=stm.toUpperCase().split(" ");
                lastTable=temp[Arrays.asList(temp).indexOf("FROM")+1].toLowerCase();
            }
        }catch(SQLException e){System.out.println(e);}
        return result;
    }

    public void printLastQuery(){
        try {
            while(result.next())
                switch (lastTable){
                    case "movies":{
                        StringBuilder temp=new StringBuilder();
                        temp.append(result.getInt(1));
                        temp.append(" ");
                        temp.append(result.getString(2));
                        temp.append(" ");
                        temp.append(result.getString(3));
                        temp.append(" ");
                        temp.append(result.getString(4));
                        temp.append(" ");
                        temp.append(result.getString(5));
                        System.out.println(temp.toString());
                        break;
                    }
                    case "genres":{
                        StringBuilder temp=new StringBuilder();
                        temp.append(result.getInt(1));
                        temp.append(" ");
                        temp.append(result.getString(2));
                        System.out.println(temp.toString());
                        break;
                    }

                }

        }catch(SQLException e){System.err.println(e);}
    }

    public String getLastTable() {
        return lastTable;
    }

    public void setLastTable(String lastTable) {
        this.lastTable = lastTable;
    }
}
