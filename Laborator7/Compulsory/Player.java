package Laborator7;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    Integer id;
    Player(String nume, Integer idul){
        name=nume;
        id=idul;
    }
    public void run(){
        System.out.println(Main.buffer.getIndex());
        if(id==Main.buffer.getIndex()){
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println(name);
            Integer x,y;
            Main.table.printBoard();
            Scanner scan = new Scanner(System.in);
            System.out.print("The x position is:");
            x=scan.nextInt();
            System.out.println();
            System.out.print("The y position is:");
            y=scan.nextInt();
            System.out.println();
            try{
                wait();
                Main.table.takePiece(x, y);
            }catch(InterruptedException e) { e.printStackTrace();}
            scan.close();
            notifyAll();
            Main.buffer.incIndex();
        }
        else{
            System.out.print("");
        }

    }
    public String getName(){
        return name;
    }
}
