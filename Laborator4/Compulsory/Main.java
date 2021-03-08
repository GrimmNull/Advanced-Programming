package Laborator4;
import java.util.stream.IntStream;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class Main{

    public static void main(String args[])
    {
        var schools=IntStream.rangeClosed(0,2).mapToObj(i -> new School("s" + i, (int)(Math.random()*5))).toArray(School[]::new);
        var students=IntStream.rangeClosed(0,3).mapToObj(i -> new Student("h" + i, (int)(Math.random()*100))).toArray(Student[]::new);
        List<Student> studenti=new LinkedList<>();
        studenti= Arrays.asList(students);
        Collections.sort(studenti, Comparator.comparing(Student::getScore));
        Set<School> scoli= new TreeSet<>(Comparator.comparing(School::getName));
        Map<Student, List<School> > preferinteStudenti=new HashMap<>();
        List<School> temp= new LinkedList<>();
        temp= Arrays.asList(schools);
        preferinteStudenti.put(students[0], temp);
        preferinteStudenti.put(students[1], temp);
        temp.clear();
        temp.add(schools[0]);
        temp.add(schools[1]);
        preferinteStudenti.put(students[2],temp);
        temp.clear();
        temp.add(schools[0]);
        temp.add(schools[2]);
        preferinteStudenti.put(students[3],temp);
        for(Map.Entry<Student, List<School> > ent : preferinteStudenti.entrySet()){
            System.out.println(ent.getKey() + ent.getValue().toString());
        }

        Map<School, List<Student> > preferinteScoli=new TreeMap<>();
        List<Student> temp2= new LinkedList<>();
        temp2.add(students[3]);
        temp2.add(students[0]);
        temp2.add(students[1]);
        temp2.add(students[2]);
        preferinteScoli.put(schools[0],temp2);
        temp2.clear();
        temp2.add(students[0]);
        temp2.add(students[2]);
        temp2.add(students[1]);
        preferinteScoli.put(schools[1],temp2);
        temp2.clear();
        temp2.add(students[0]);
        temp2.add(students[1]);
        temp2.add(students[3]);
        preferinteScoli.put(schools[1],temp2);
        for(Map.Entry<School, List<Student> > ent : preferinteScoli.entrySet()){
            System.out.println(ent.getKey() + ent.getValue().toString());
        }
    }
}