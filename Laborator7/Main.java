package Laborator7;

public class Main {
    public static Board table=new Board();

    public static Buffer buffer= new Buffer(1);
    public static void main(String[] args){
        Player p1= new Player("Jordan",0);
        Player p2= new Player("Gary",1);
            new Thread(p1).start();
            new Thread(p2).start();
    }
}
