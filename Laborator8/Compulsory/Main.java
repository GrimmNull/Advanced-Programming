import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args){
        DBConnection myDB=DBConnection.getConnection();
        List<Movie> lista=MovieDAO.findAll(myDB);
        for(Movie item : lista){
            System.out.println(item);
        }
        System.out.println();
        Movie mov=new Movie(5,"Batman","03-JUL-2000", 120,101);
        MovieDAO.insertMovie(myDB,mov);
        lista=MovieDAO.findAll(myDB);
        for(Movie item : lista){
            System.out.println(item);
        }
        System.out.println();
        mov.setScore(40);
        MovieDAO.updateMovie(myDB, mov);
        lista=MovieDAO.findAll(myDB);
        for(Movie item : lista){
            System.out.println(item);
        };
        System.out.println();
        MovieDAO.deleteMovie(myDB,mov);
    }
}