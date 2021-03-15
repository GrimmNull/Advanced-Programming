package Laborator5;
import java.time.LocalTime;

public class Song extends Item {
    private LocalTime duration;
    Song(){
        duration=LocalTime.parse("00:00");
    }
    Song(String nume, String tip, String cale, LocalTime durata){
        super(nume,tip,cale);
        duration=durata;
    }
    public String getType(){
        return "song";
    }
    public LocalTime getDuration(){
        return duration;
    }
    public void setDuration(LocalTime durata){
        duration=durata;
    }
    public void setDuration(String durata){
        duration=LocalTime.parse(durata);
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append(getName());
        temp.append(" ");
        temp.append(getType());
        temp.append(" ");
        temp.append(duration.toString());
        temp.append(" ");        
        temp.append(getPath());
        return temp.toString();
    }
}
