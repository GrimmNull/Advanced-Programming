package Laborator3;
import java.time.LocalTime;
import java.util.Map;

public class Hotel  extends Location implements Visitable, Clasifiable{
    private Integer rank;
    private LocalTime openingTime, closingTime;
    private double minRoomPrice;
    Hotel(){
        openingTime=LocalTime.parse("24:01");
        closingTime=LocalTime.parse("24:01");
        minRoomPrice=-1;
    }
    Hotel(String nume, Map<Location, Integer> deVizitat, double pret, LocalTime oraDeDeschidere, LocalTime oraDeInchidere){
        super(nume,deVizitat);
        minRoomPrice=pret;
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
    public double getMinRoomPrice(){
        return minRoomPrice;
    }
    public void setOpeningHour(LocalTime ora){
        openingTime=ora;
    }
    public void setClosingHour(LocalTime ora){
        closingTime=ora;
    }
    public void setMinRoomPrice(double pret){
        minRoomPrice=pret;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Hotelul ");
        temp.append(getName());
        temp.append(" se deschide la ora ");
        temp.append(openingTime);
        temp.append(" si se inchide la ora ");
        temp.append(closingTime);
        temp.append(".");
        temp.append(" Acesta are camere disponibile care incep de la pretul de ");
        temp.append(minRoomPrice);
        temp.append(" lei.");
        return temp.toString();
    }    
}
