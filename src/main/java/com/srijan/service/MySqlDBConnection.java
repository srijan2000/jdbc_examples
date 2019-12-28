package com.srijan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {

    private static String connectionString = "jdbc:mysql://localhost:3306/my_db";
    private static String username = "root";
    private static String password = "root";

    public Connection getDBConnectio(){
        //loading driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(connectionString, username, password);
            return conn;
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return null;
    }
}
