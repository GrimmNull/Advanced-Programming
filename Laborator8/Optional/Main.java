import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        DBConnection myDB=DBConnection.getConnection();
        List<Movie> lista=MovieDAO.findAll(myDB);
        for(Movie item : lista){
            System.out.println(item);
        }
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
        Movie atemp=MovieDAO.findById(myDB,6);

         */
        DBConnection.initializeDatabase("src/IMDb movies.csv");
    }
}