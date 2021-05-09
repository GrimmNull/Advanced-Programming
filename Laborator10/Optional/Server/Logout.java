public class Logout {
    public String execute(String[] args) {
        Client clientTemp = SocketServer.findUserByPort(Integer.parseInt(args[0]));
        if (clientTemp != null)
            clientTemp.setConnectedPort(-1);
        return "You were logged out!";
    }
}
