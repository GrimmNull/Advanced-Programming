import java.sql.*;
public class DBConnection {
    private Statement stmt;
    private ResultSet result;
    private Connection con;
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
        }catch(SQLException e){System.out.println(e);}
        return result;
    }
    public void printLastQuery(){
        try {
            while(result.next())
                System.out.println(result.getInt(1)+"  "+result.getString(2)+"  "+result.getString(3));
        }catch(SQLException e){System.err.println(e);}
    }
}
