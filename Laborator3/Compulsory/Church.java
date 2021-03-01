package Laborator3;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;
    String denomination;
    Church(){
        openingTime=LocalTime.parse("24:01");
        closingTime=LocalTime.parse("24:01");
        denomination="default";
    }
    Church(String nume, Map<Location, Integer> deVizitat, String denominatiune, LocalTime oraDeDeschidere, LocalTime oraDeInchidere){
        super(nume,deVizitat);
        denomination=denominatiune;
        openingTime=oraDeDeschidere;
        closingTime=oraDeInchidere;
    }
    public LocalTime getOpeningHour(){
        return openingTime;
    }
    public LocalTime getClosingHour(){
        return closingTime;
    }
    public void setOpeningHour(LocalTime ora){
        openingTime=ora;
    }
    public void setClosingHour(LocalTime ora){
        closingTime=ora;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Biserica ");
        temp.append(getName());
        temp.append(" se deschide la ora ");
        temp.append(openingTime);
        temp.append(" si se inchide la ora ");
        temp.append(closingTime);
        temp.append(".");
        return temp.toString();
    }
}
