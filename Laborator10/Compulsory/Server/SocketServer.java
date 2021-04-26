import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static final int PORT = 8100;
    private static ServerSocket serverSocket;
    private static Boolean running;
    public SocketServer() throws IOException {
        serverSocket = null;
        running=true;
        try {
            serverSocket = new ServerSocket(PORT);
            while (running)
            {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new SocketClient(socket).start();
            }
        }catch (IOException e)
        {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void stopServer() throws IOException {
        System.out.println("I will attempt to stop the server");
        running=false;
    }
}
