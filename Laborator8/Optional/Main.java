import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static j2html.TagCreator.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DBConnection myDB=DBConnection.getConnection();
        myDB.resetDatabase();
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


        myDB.initializeDatabase("src/IMDb movies.csv");
        myDB.queryTheDatabase("select * from movies");
        myDB.printLastQuery();
        System.out.println();
        List<MovieGenres> lista3=MovieGenresDAO.findAll(myDB);
        System.out.println("I got the list");
        for(MovieGenres item : lista3){
                Movie filmTemporar=MovieDAO.findById(myDB,item.getIdMovie());
                Genre genreTemporar=GenreDAO.findById(myDB,item.getIdGenre());
                StringBuilder temp=new StringBuilder();
                temp.append(filmTemporar.getTitle());
                temp.append(" : ");
                temp.append(genreTemporar.getName());
                System.out.println(temp.toString());
        }
    }
}