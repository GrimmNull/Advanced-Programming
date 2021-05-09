public class Register {
    public String execute(String[] args) {
        Client clientTemp = SocketServer.findUserByName(args[1]);
        if (clientTemp == null) {
            SocketServer.addUser(new Client(args[1], Integer.parseInt(args[0])));
            return "Account successfully created!";
        } else {
            return "There is already someone with this name";
        }
    }
}
