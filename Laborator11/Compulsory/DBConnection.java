package com.example.laborator11;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class DBConnection {
    private Statement stmt;
    private ResultSet result;
    private Connection con;
    private static DBConnection dbConn = null;

//    private DBConnection() {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public static DBConnection getConnection() {
        if (dbConn == null)
            dbConn = new DBConnection();
        return dbConn;
    }

    public ResultSet queryTheDatabase(String stm) {
        try {
            if (con == null || con.isClosed())
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persoane", "root", "parolanoua");
            stmt = con.createStatement();
            result = stmt.executeQuery(stm);
            if (stm.toUpperCase().contains("SELECT")) {
                String[] temp = stm.toUpperCase().split(" ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

}
