import org.dom4j.Attribute;
import org.dom4j.tree.DefaultAttribute;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class SocketServer {
    public static final int PORT = 8100;
    private static Boolean running;
    public static ArrayList<Client> users = new ArrayList<>();

    public SocketServer() throws IOException {
        ServerSocket serverSocket;
        serverSocket = null;
        running = true;
        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                System.out.println("The port is:" + socket.getPort());
                new SocketClient(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void stopServer() throws IOException {
        System.out.println("I will attempt to stop the server");
        running = false;
    }

    public static Client findUserByPort(Integer port) {
        for (Client temp : users) {
            if (temp.getConnectedPort().equals(port))
                return temp;
        }
        return null;
    }

    public static Client findUserByName(String nume) {
        for (Client temp : users) {
            if (temp.getName().equals(nume))
                return temp;
        }
        return null;
    }

    public static void addUser(Client user) {
        users.add(user);
    }

    public static void printUsers() {
        for (Client temp : users) {
            System.out.println(temp);
            System.out.println();
        }
    }

    public static void createGraph() throws URISyntaxException {
        Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        ArrayList<URI> useriURI = new ArrayList<>();
        for (Client it : users) {
            URI uriTemp = new URI(it.getName());
            useriURI.add(uriTemp);
            g.addVertex(uriTemp);
        }
        for (Client it : users) {
            URI source=useriURI.get(users.indexOf(it));
            for(Client friend : it.getFriends()){
                URI destination=useriURI.get(users.indexOf(friend));
                g.addEdge(source,destination);
            }
        }
        DOTExporter<URI, DefaultEdge> exporter =
                new DOTExporter<>(v -> v.getHost().replace('.', '_'));
        exporter.setVertexAttributeProvider((v) -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(v.toString()));
            return map;
        });
        Writer writer = new StringWriter();
        exporter.exportGraph(hrefGraph, writer);
        System.out.println(writer.toString());
    }
}
