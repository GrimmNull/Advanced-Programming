public class Read {
    public String execute(String[] args){
        Client clientTemp=SocketServer.findUserByPort(Integer.parseInt(args[0]));
        StringBuilder stringTemp=new StringBuilder();
        for(String it : clientTemp.getMessages()){
            stringTemp.append(it);
            stringTemp.append("\n");
        }
        return stringTemp.toString();
    }
}
