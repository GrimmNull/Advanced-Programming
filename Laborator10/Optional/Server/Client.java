import java.util.ArrayList;

public class Client {
    private String name;
    private Integer connectedPort;
    private ArrayList<Client> friends = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();

    Client(String nume) {
        name = nume;
        connectedPort = -1;
    }

    Client(String nume, Integer port) {
        name = nume;
        connectedPort = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConnectedPort() {
        return connectedPort;
    }

    public void setConnectedPort(Integer connectedPort) {
        this.connectedPort = connectedPort;
    }

    public ArrayList<Client> getFriends() {
        return friends;
    }

    public void addFriend(Client friend) {
        this.friends.add(friend);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void addMessage(String newMessage) {
        messages.add(newMessage);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", connectedPort=" + connectedPort +
                '}';
    }
}
