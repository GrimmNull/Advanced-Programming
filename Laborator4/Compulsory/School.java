package Laborator4;
import java.util.LinkedList;
import java.util.List;

public class School implements Comparable<School>{
    int capacity;
    String name;
    List<Student> preferedStudents=new LinkedList<>();
    School(){
        capacity=-1;
        name="default";
    }
    School(String nume){
        name=nume;
        capacity=-1;
    }
    School(String nume, int capacitate){
        name=nume;
        capacity=capacitate;
    }
    School(String nume, int capacitate, List<Student> preferinte){
        name=nume;
        capacity=capacitate;
        preferedStudents.addAll(preferinte);
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacitate){
        capacity=capacitate;
    }
    public String getName(){
        return name;
    }
    public void setName(String nume){
        name=nume;
    }
    public List<Student> getPreferences(){
        return preferedStudents;
    }
    public void setPreferences(List<Student> preferinte){
        preferedStudents.addAll(preferinte);
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append("Scoala ");
        temp.append(name);
        temp.append(" care are capacitatea de ");
        temp.append(capacity);
        temp.append(" si prefera studentii: (");
        for(Student i: preferedStudents){
            temp.append(i.getName());
            temp.append(", ");
        }
        temp.append(")");
        return temp.toString();
    }

    public int compareTo(School scoala)
    {
        return this.name.compareTo(scoala.getName());
    }
}
