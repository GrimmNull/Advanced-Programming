package com.laborator12.classes;

import org.junit.Test;

public class ClasaDeTest {
    private Integer int1,int2;
    private String name="Gabriel",surname;
    private Boolean yes;
    private static final Integer age=20;

    public ClasaDeTest(){
        int1=-1;
        int2=-2;
        surname="Grimmy";
        yes=true;
    }

    public ClasaDeTest(Integer int1, Integer int2, String name, String surname, Boolean yes) {
        this.int1 = int1;
        this.int2 = int2;
        this.name = name;
        this.surname = surname;
        this.yes = yes;
    }

    @Test
    public static void prezentare(){
        StringBuilder temp=new StringBuilder();
        temp.append("I am ")
                .append(age)
                .append(" years old");
        System.out.println(temp.toString());
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getYes() {
        return yes;
    }

    public void setYes(Boolean yes) {
        this.yes = yes;
    }

    @Override
    public String toString() {
        return "com.laborator12.classes.ClasaDeTest{" +
                "int1=" + int1 +
                ", int2=" + int2 +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yes=" + yes +
                '}';
    }
}
