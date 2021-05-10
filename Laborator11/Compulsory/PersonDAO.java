package com.example.laborator11;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {
    public static List<Person> findAll(DBConnection myDB){
        List<Person> res=new LinkedList<>();
        ResultSet set=myDB.queryTheDatabase("SELECT * FROM people");
        try {
            while(set.next())
                res.add(new Person(set.getInt(1),set.getString(2)));
        }catch(SQLException e){System.err.println(e);}
        return res;
    }
    public static Person findById(DBConnection myDB,int id){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM people WHERE id=");
        temp.append(id);
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Person(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static Person findByName(DBConnection myDB, String name){
        StringBuilder temp=new StringBuilder();
        temp.append("SELECT * FROM people WHERE name='");
        temp.append(name);
        temp.append("'");
        ResultSet set=myDB.queryTheDatabase(temp.toString());
        try {
            if(set==null)
                return null;
            else{
                set.next();
                return new Person(set.getInt(1),set.getString(2));
            }
        }catch(SQLException e){System.err.println(e);}
        return null;
    }
    public static void insertPerson(DBConnection myDB,Person persoana){
        StringBuilder temp=new StringBuilder();
        temp.append("INSERT INTO people (id, name) VALUES (");
        temp.append(persoana.getId());
        temp.append(", '");
        temp.append(persoana.getName());
        temp.append("')");
        myDB.queryTheDatabase(temp.toString());
    }

    public static void updatePerson(DBConnection myDB, Person persoana){
        StringBuilder temp=new StringBuilder();
        temp.append("UPDATE people");
        temp.append("SET name='");
        temp.append(persoana.getName());
        temp.append("' WHERE id=");
        temp.append(persoana.getId());
        myDB.queryTheDatabase(temp.toString());
    }
    public static void deletePerson(DBConnection myDB, Person persoana){
        StringBuilder temp=new StringBuilder();
        temp.append("DELETE FROM people WHERE id=");
        temp.append(persoana.getId());
        myDB.queryTheDatabase(temp.toString());
    }
}
