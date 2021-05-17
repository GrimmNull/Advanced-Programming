package com.laborator12.classes;

import org.junit.Test;

import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Loader {
    Class loadedClass;
    URLClassLoader classPath;
    Method[] methods;
    Constructor[] cons;
    Field[] fields;

    public Loader(){
        loadedClass=null;
        classPath=null;
        methods=null;
        cons=null;
        fields=null;
    }

    public void loadClassByPath(String nameOfClass) throws ClassNotFoundException {
        loadedClass=Class.forName(nameOfClass);
        methods=loadedClass.getMethods();
        cons=loadedClass.getConstructors();
        fields=loadedClass.getFields();
    }


    public void getClassName(){
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }
        StringBuilder temp=new StringBuilder();
        System.out.println(temp.append("The name of the class is: ")
                .append(loadedClass.getName())
                .toString());
    }

    public void getPackage(){
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }
        StringBuilder temp=new StringBuilder();
        System.out.println(temp.append("The package is: ")
                .append(loadedClass.getPackage().toString().replace("package ",""))
                .toString());
    }

    public void getConstructor() throws NoSuchMethodException {
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }

        for(Constructor temp : cons){
            if(temp.getParameterCount()>0){
                Class[] parametersType=temp.getParameterTypes();
                System.out.print("It takes the following parameters:");
                for(Class temp2 : parametersType)
                {
                    System.out.print(temp2.getTypeName().toString().replace("java.lang.",""));
                    System.out.print(", ");
                }
            }else{
                System.out.println("It has a default constructor");
            }
        }
        System.out.println();
    }

    public void getMethods(){
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }
        System.out.println("These are the names of the methods that this class contains:");
        for(Method temp : methods){
            System.out.println(temp.getName());
        }
    }

    public void getFields(){
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }
        System.out.println("These are the names of the fields that this class contains:");
        for(Field temp : fields){
            System.out.println(temp.getName());
        }
    }

    public void getMethodsParameters(){
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }
        System.out.println("These are the parameter types of the methods: ");
        for(Method temp : methods){
            if(temp.getParameterCount()>0){
                Class[] parametersType=temp.getParameterTypes();
                System.out.print(temp.getName());
                System.out.print(": ");
                for(Class temp2 : parametersType)
                {
                    System.out.print(temp2.getTypeName().toString().replace("java.lang.",""));
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
    }

    public void runTestMethods() throws InvocationTargetException, IllegalAccessException {
        if(loadedClass==null){
            System.out.println("The class was not loaded yet");
            return;
        }

        for(Method temp : methods){
            if(temp.isAnnotationPresent(Test.class) && temp.getParameterCount()==0){
                temp.invoke(null);
            }
        }
    }
}
