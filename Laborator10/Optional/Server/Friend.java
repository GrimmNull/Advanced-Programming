public class Friend {
    public String execute(String[] args) {
        Client clientTemp = SocketServer.findUserByPort(Integer.parseInt(args[0]));
        StringBuilder raspuns=new StringBuilder();
        for(int i=1;i<args.length;i++){
            Client prietenTemp=SocketServer.findUserByName(args[i]);
            if(prietenTemp==null){
                raspuns.append("The user ");
                raspuns.append(args[i]);
                raspuns.append(" does not exist!");
            }
            else{
                clientTemp.addFriend(prietenTemp);
                raspuns.append("The user ");
                raspuns.append(args[i]);
                raspuns.append(" has been added to your friend list!");
            }
        }
        return raspuns.toString();
    }
}
