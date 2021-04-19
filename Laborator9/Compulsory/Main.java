import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "Movies";
    private static EntityManagerFactory factory;
    public static void main(String[] args) throws FileNotFoundException {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
    }
}