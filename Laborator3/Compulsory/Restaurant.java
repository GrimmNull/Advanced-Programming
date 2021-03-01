package Laborator3;
import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable, Clasifiable{
    private Integer rank;
    private LocalTime openingTime, closingTime;
    private double minMealPrice;
    Restaurant(){
        openingTime=LocalTime.parse("24:01");
        closingTime=LocalTime.parse("24:01");
        minMealPrice=-1;
    }
    Restaurant(String nume, Map<Location, Integer> deVizitat, double pret, LocalTime oraDeDeschidere, LocalTime oraDeInchidere){
        super(nume,deVizitat);
        minMealPrice=pret;
        openingTime=oraDeDeschidere;
        closingTime=oraDeInchidere;
    }
    public Integer getRank(){
        return rank;
    }
    public void setRank(Integer rang){
        rank=rang;
    }
    public LocalTime getOpeningHour(){
        return openingTime;
    }
    public LocalTime getClosingHour(){
        return closingTime;
    }
    public double getMinMealPrice(){
        return minMealPrice;
    }
    public void setOpeningHour(LocalTime ora){
        openingTime=ora;
    }
    public void setClosingHour(LocalTime ora){
        closingTime=ora;
    }
    public void setMinMealPrice(double pret){
        minMealPrice=pret;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Restaurantul ");
        temp.append(getName());
        temp.append(" se deschide la ora ");
        temp.append(openingTime);
        temp.append(" si se inchide la ora ");
        temp.append(closingTime);
        temp.append(".");
        temp.append(" Acesta are in meniu specialitati care incep de la ");
        temp.append(minMealPrice);
        temp.append(" lei.");
        return temp.toString();
    }
}
