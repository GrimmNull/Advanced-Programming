package Laborator3;
import java.time.LocalTime;
import java.util.Map;
public class Museum extends Location implements Visitable, Payable, Clasifiable
{
    private Integer rank;
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    Museum(){
        ticketPrice=-1;
        openingTime=LocalTime.parse("24:01");
        closingTime=LocalTime.parse("24:01");
    }
    Museum(String nume, Map<Location, Integer> deVizitat, double pretTichet, LocalTime oraDeDeschidere, LocalTime oraDeInchidere){
        super(nume,deVizitat);
        ticketPrice=pretTichet;
        openingTime=oraDeDeschidere;
        closingTime=oraDeInchidere;
    }
    public Integer getRank(){
        return rank;
    }
    public void setRank(Integer rang){
        rank=rang;
    }
    @Override
    public LocalTime getOpeningHour() 
    {
        return openingTime;
    }
    public void setOpeningHour(LocalTime openingTime) 
    {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getClosingHour() 
    {
        return closingTime;
    }
    public void setClosingHour(LocalTime closingTime) 
    {
        this.closingTime = closingTime;
    }
    @Override
    public double getTicketPrice() 
    {
        return ticketPrice; 
    }
    public void setTicketPrice(double pret){
        ticketPrice=pret;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Muzeul ");
        temp.append(getName());
        temp.append(" poate fi vizitat intre orele ");
        temp.append(openingTime);
        temp.append(" si ");
        temp.append(closingTime);
        temp.append(", iar biletul costa ");
        temp.append(ticketPrice);
        temp.append(" lei.");
        return temp.toString();
    }
}