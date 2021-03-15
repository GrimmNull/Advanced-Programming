package Laborator5;
import java.util.List;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException; 

public class Catalog {
    List<Item> items=new LinkedList<>();
    private int length;
    Catalog(){
        length=0;
    }
    public void addItem(Item temp){
        temp.setId(length);
        items.add(temp);
        length+=1;
    }
    public void listContent(){
        for(Item temp : items){
            System.out.println(temp);
        }
    }
    public Item findItem(String nume){
        for(Item temp : items){
            if(nume.equals(temp.getName())){
                return temp;
            }
        }
        return null;
    }
    public void saveCatalog(){  
        try {
            FileWriter outputFile = new FileWriter("filename.txt");
            for(Item temp : items){
                outputFile.write(temp.toString());
            }
            outputFile.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

}
