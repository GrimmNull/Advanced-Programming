package com.example.laborator11;

import java.util.ArrayList;

public class Person {
    private String name;
    private Integer id;
    ArrayList<Person> friends=new ArrayList<>();
    Person(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Person> getFriends(){
        return friends;
    }

    public void setName(String nume){
        name=nume;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void addFriend(Person temp){
        friends.add(temp);
    }


}
