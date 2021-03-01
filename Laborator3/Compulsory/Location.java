package Laborator3;
import java.util.Map;
import java.util.HashMap;

public abstract class Location implements Comparable<Location>
{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();
    Location(){
        name="default";
    }
    Location(String nume, Map<Location, Integer> costuri)
    {
        name=nume;
        cost=costuri;
    }
    public String getName(){
        return name;
    }
    public Map<Location, Integer> getCost(){
        return cost;
    }
    public void setName(String nume){
        name=nume;
    }
    public void setCosts(Map<Location, Integer> costuri){
        cost=costuri;
    }
    public void setCost(Location node, int value) 
    {
        cost.put(node, value);
    }    
    @Override
    public String toString(){
        StringBuilder temp= new StringBuilder();
        temp.append("Locatia ");
        temp.append(name);
        temp.append(" are legaturi cu: ");
        for(Map.Entry<Location, Integer> dest: cost.entrySet()){
            temp.append(dest.getKey().name);
            temp.append(" cu costul de ");
            temp.append(dest.getValue());
            temp.append("; ");
        }
        return temp.toString();
    }
    @Override
    public int compareTo(Location other) 
    {
        if(this.name!=null && other.name!=null){
            return this.name.compareTo(other.name);
        }
        return -1;
    }
}