package com.laborator12.classes;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.print("Write the path to the class: ");
        Scanner scanner = new Scanner(System.in);
        String classPath;
        //classPath= scanner.nextLine();
        classPath="com.laborator12.classes.ClasaDeTest";
        Loader classLoader=new Loader();
        classLoader.loadClassByPath(classPath);
        classLoader.getClassName();
        System.out.println();
        classLoader.getPackage();
        System.out.println();
        classLoader.getConstructor();
        System.out.println();
        classLoader.getMethods();
        System.out.println();
        classLoader.getFields();
        System.out.println();
        classLoader.runTestMethods();
        System.out.println();
        classLoader.getMethodsParameters();
    }
}
