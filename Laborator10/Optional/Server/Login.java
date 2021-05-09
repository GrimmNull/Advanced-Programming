


public class Login {
    public String execute(String[] args) {
        Client clientTemp = SocketServer.findUserByName(args[1]);
        if (clientTemp == null) {
            return "There is no profile with this name";
        } else if (clientTemp.getConnectedPort() != -1) {
            return "There is already someone connected to this account";
        } else {

            clientTemp.setConnectedPort(Integer.parseInt(args[0]));
            return "Connected successfully!";
        }
    }
}
