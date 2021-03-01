package Laborator3;
import java.util.List;
import java.util.ArrayList;

public class City 
{
    private List<Location> nodes = new ArrayList<>();
    //... constructors, getters, setters
    City(List<Location> locatii){
        nodes=locatii;
    }
    public void addLocation(Location node) 
    {
        nodes.add(node);
    }
    @Override
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Orasul are urmatoarele destinatii: ");
        for(Location entry: nodes){
            temp.append(entry.getName());
            temp.append(", ");
        }
        temp.append(";");
        return temp.toString();
    }
}
