package Laborator5;
import java.time.LocalTime;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.File;
import java.awt.Desktop;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    static Catalog myCatalog= new Catalog();
    public static void add() throws IOException{
        String nume, tip, cale, extensie,rezolutie;
        LocalTime durata;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Type the name of the item:");
        nume=reader.readLine();
        System.out.println("Type the path to the file:");
        cale=reader.readLine();
        System.out.println("Write the type of your file:");
        tip=reader.readLine();
        if(tip.equals("song")){
            System.out.println("Type the length of the song:");
            durata=LocalTime.parse(reader.readLine());
            Song mel= new Song(nume,tip,cale,durata);
            myCatalog.addItem(mel);
        } else {
            System.out.println("Type the extension of the image:");
            extensie=reader.readLine();
            System.out.println("Type the resolution of the image:");
            rezolutie=reader.readLine();
            Image img= new Image(nume,tip,cale,extensie,rezolutie);
            myCatalog.addItem(img);
        }
    }
    public static void list(){
        myCatalog.listContent();
    }
    public static void play(String nume){
        Item temp = myCatalog.findItem(nume);
        if(temp==null){
            System.err.println("There is no file with this name");
            return;
        }
    File f = new File(temp.getPath());
        try {
            Desktop.getDesktop().open(f);
         }catch (IOException e) {
            System.err.println("There is no such file");
            e.printStackTrace();
        }
    }
    public static void save(){
        myCatalog.saveCatalog();
    }
    public static void load(String cale){
        try {
            File myInput = new File(cale);
            Scanner myReader = new Scanner(myInput);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] splited = data.split(" ");
              if("song".equals(splited[1])){
                  Song mel= new Song(splited[0],splited[1],splited[3],LocalTime.parse(splited[2]));
                  myCatalog.addItem(mel);
              } else {
                  Image img= new Image(splited[0],splited[1],splited[4],splited[2],splited[3]);
                  myCatalog.addItem(img);
              }

            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public static void main(String args[]){

    }
}
