public class Send {
    public String execute(String[] args){
        Client clientTemp=SocketServer.findUserByPort(Integer.parseInt(args[0]));
        for(Client it : clientTemp.getFriends()){
            it.addMessage(args[1]);
        }
        return "Your message was sent successfully!";
    }
}
