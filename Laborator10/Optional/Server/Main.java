import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SocketServer server = new SocketServer();
        server.createGraph();
    }

}
