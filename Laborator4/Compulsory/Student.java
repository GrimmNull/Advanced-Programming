package Laborator4;
import java.util.List;
import java.util.LinkedList;

public class Student implements Comparable<Student>{
    private int score;
    private String name;
    private List<School> preferedSchools= new LinkedList<>();
    Student(){
        score=-1;
        name="default";
    }
    Student(String nume){
        name=nume;
        score=-1;
    }
    Student(String nume, int scor){
        name=nume;
        score=scor;
    }
    Student(String nume, int scor, List<School> preferinte){
        name=nume;
        score=scor;
        preferedSchools.addAll(preferinte);
    }

    public int getScore(){
        return score;
    }
    public void setScore(int scor){
        score=scor;
    }
    public String getName(){
        return name;
    }
    public void setName(String nume){
        name=nume;
    }
    public List<School> getPreferences(){
        return preferedSchools;
    }
    public void setPreferences(List<School> preferinte){
        preferedSchools.addAll(preferinte);
    }

    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Studentul ");
        temp.append(name);
        temp.append(" are scorul de ");
        temp.append(score);
        temp.append(" puncte si doreste sa intre la: ");
        for(School i : preferedSchools){
            temp.append(i.toString());
            temp.append("; ");
        }
        temp.append(".");
        return temp.toString();
    }
    public int compareTo(Student st){  
        if(score==st.getScore())  
            return 0;  
        else if(score>st.getScore())  
                return 1;  
             else  
                return -1;  
        }  
}
