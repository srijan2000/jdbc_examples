package com.srijan;
import java.sql.*;

public class MySqlDbConnector {
    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable To Load The class");
        }
    }
    public static void  main(String[] args){
        Connection connection = null ;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String connectionString = "jdbc:mysql://localhost:3306/my_db";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(connectionString,username,password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from organization");

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("org_name"));
                System.out.println(resultSet.getString("description"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
