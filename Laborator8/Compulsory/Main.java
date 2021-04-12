import java.sql.*;
public class Main {
    public static void main(String[] args){
        DBConnection myDB=DBConnection.getConnection();
        ResultSet rezultat= myDB.queryTheDatabase("select * from movies");
        myDB.printLastQuery();
    }
}