import java.io.FileNotFoundException;
import java.util.List;

import static j2html.TagCreator.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DBConnection myDB=DBConnection.getConnection();
        DBConnection.resetDatabase();
        System.out.println("I reset the database");
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


        DBConnection.initializeDatabase("src/IMDb movies.csv");
        System.out.println("Welp, I did it");


    }
}