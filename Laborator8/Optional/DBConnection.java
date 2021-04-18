import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

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
    private static String functionToMap(String temp){
        if(temp.charAt(0)==' ')
            return temp.replaceFirst(" ","");
        else
            return temp;
    }
    public static void initializeDatabase(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int idMovie=1,idActor=1,idGenre=1,idDirector=1;
        sc.useDelimiter("\n");
        for(int i=0;i<7;i++){
            String[] temp=sc.next().split(",");
            Movie mov=new Movie(idMovie,temp[0],temp[1],Integer.parseInt(temp[3]),(int)(Float.parseFloat(temp[6])*10));
            //System.out.println(mov);
            String[] actors=Arrays.stream(temp[5].split(";"))
                    .map(actor -> functionToMap(actor))
                    .toArray(String[]::new);

            for(String item : actors){
                if(ActorDAO.findByName(dbConn, item)==null){
                    Actor actorTemporar= new Actor(idActor,item);
                    ActorDAO.insertActor(dbConn,actorTemporar);
                    Acting actingTemporar=new Acting(ActorDAO.findByName(dbConn, item).getId(),idMovie);
                    ActingDAO.insertActing(dbConn,actingTemporar);
                    idActor++;
                }
                else
                {
                    Acting actingTemporar=new Acting(ActorDAO.findByName(dbConn, item).getId(),idMovie);
                }
            }
            System.out.println();
            idMovie++;
        }

        sc.close();

    }

    public String getLastTable() {
        return lastTable;
    }

    public void setLastTable(String lastTable) {
        this.lastTable = lastTable;
    }
}
