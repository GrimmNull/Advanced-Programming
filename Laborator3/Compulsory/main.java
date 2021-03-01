package Laborator3;
import java.time.LocalTime;
public class main 
{
    public static void main(String args[]) 
    {
        Museum m = new Museum();
        m.setOpeningHour(LocalTime.of(9, 30)); 
        //9:30
        m.setClosingHour(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        Church c = new Church();
        c.setOpeningHour(LocalTime.of(7, 0));
        c.setClosingHour(LocalTime.MIDNIGHT);
        Visitable[] arr = {m, c};
    }
}
