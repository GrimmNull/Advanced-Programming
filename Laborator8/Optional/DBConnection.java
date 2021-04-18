import java.io.*;
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
        }catch(SQLException e){System.out.println(e); System.out.println(stm);}
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
        while(sc.hasNext() && idMovie<10){
            String[] temp=sc.next().split(",");
            Movie mov=new Movie(idMovie,temp[0],temp[1],Integer.parseInt(temp[3]),(int)(Float.parseFloat(temp[6])*10));
            MovieDAO.insertMovie(dbConn,mov);

            if(temp[5]!=""){
                String[] actors=Arrays.stream(temp[5].split(";"))
                        .map(actor -> functionToMap(actor))
                        .toArray(String[]::new);
            for(String item : actors){
                if(ActorDAO.findByName(dbConn, item)==null){
                    Actor actorTemporar= new Actor(idActor,item);
                    ActorDAO.insertActor(dbConn,actorTemporar);
                    Acting actingTemporar=new Acting(idActor,idMovie);
                    ActingDAO.insertActing(dbConn,actingTemporar);
                    System.out.println("I added an actor");
                    idActor++;
                }
                else{
                    Acting actingTemporar=new Acting(ActorDAO.findByName(dbConn, item).getId(),idMovie);
                    System.out.println("There was already the actor");
                    ActingDAO.insertActing(dbConn,actingTemporar);
                }
            }
            }

            if(temp[4]!=""){
                String[] directors= Arrays.stream(temp[4].split(";"))
                        .map(director -> functionToMap(director))
                        .toArray(String[]::new);
                for(String item : directors){
                if(DirectorDAO.findByName(dbConn,item)==null){
                    Director directorTemporar=new Director(idDirector,item);
                    DirectorDAO.insertDirector(dbConn,directorTemporar);
                    Directing directingTemporar=new Directing(idDirector,idMovie);
                    DirectingDAO.insertDirecting(dbConn,directingTemporar);
                    idDirector++;
                }
                else{
                    Directing directingTemporar=new Directing(DirectorDAO.findByName(dbConn,item).getId(),idMovie);
                    DirectingDAO.insertDirecting(dbConn,directingTemporar);
                }
                }
            }

            if(temp[2]!=""){
                String[] genres=Arrays.stream(temp[2].split(";"))
                        .map(genre -> functionToMap(genre))
                        .toArray(String[]::new);
                for(String item : genres){
                    if(GenreDAO.findByName(dbConn,item)==null){
                        Genre genreTemporar=new Genre(idGenre,item);
                        GenreDAO.insertGenre(dbConn,genreTemporar);
                        MovieGenres genresTemporar=new MovieGenres(idMovie, idGenre);
                        MovieGenresDAO.insertMovieGenre(dbConn,genresTemporar);
                        idGenre++;
                    }
                    else{
                        MovieGenres genresTemporar=new MovieGenres(idMovie, GenreDAO.findByName(dbConn,item).getId());
                        MovieGenresDAO.insertMovieGenre(dbConn,genresTemporar);
                    }
                }
            }
            idMovie++;
        }

        sc.close();

    }

    public static void resetDatabase(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/database.sql"));
            String line = reader.readLine();
            while (line != null) {
                if(line=="")
                    line+= reader.readLine();
                dbConn.queryTheDatabase(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLastTable() {
        return lastTable;
    }

    public void setLastTable(String lastTable) {
        this.lastTable = lastTable;
    }
}
