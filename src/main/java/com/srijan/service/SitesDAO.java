package com.srijan.service;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class SitesDAO {

    //fetching records
    public void display(){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from organization");
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("site_name"));
                System.out.println(rs.getString("description"));
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //inserting records
    public static void addSites(String SiteName, String desc){
        String sqlInsert = "insert into site (site_name, description) values(?, ?)";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, SiteName);
            ps.setString(2, desc);
            ps.execute();
            connection.commit();
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //updating records
    public static void updateSites(int id, String siteName, String desc){

        String sqlUpdate = "update site set site_name = ?, description = ?, modified_at = ? where id = ?";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {

            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,siteName);
            preparedStatement.setString(2, desc);

            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(3, sqlDate);

            preparedStatement.setInt(4, id);
            preparedStatement.execute();
            connection.commit();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    //deleting records
    public void deleteSite(int id){
        String sqlDelete = "delete from site where id = ?";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        //CRUD ->
        // Create, Retrieve, Update, Delete
        SitesDAO sitesDAO = new SitesDAO();
        //insertion
        sitesDAO.addSites("OU College Store.com", "Sells tennis bats");
        //update
        sitesDAO.updateSites(1,"Srijan Automobiles.com", "Sells BMW");
        //deletion
        //sitesDAO.deleteSite(7);
        //fetching
        sitesDAO.display();
    }
}
