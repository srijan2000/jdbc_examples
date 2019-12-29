package com.srijan.service;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class OrganizationDAO {

    //fetching records
    public void display(){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from organization");
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("org_name"));
                System.out.println(rs.getString("description"));
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //inserting records
    public void addOrganization(String orgName, String desc){
        String sqlInsert = "insert into organization (org_name, description) values(?, ?)";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, orgName);
            ps.setString(2, desc);
            ps.execute();
            connection.commit();
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    //updating records
    public void updateOrganization(int id, String orgName, String desc){

        String sqlUpdate = "update organization set org_name = ?, description = ?, modified_at = ? where id = ?";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnection();
        try {

            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,orgName);
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
    public void deleteOrgnization(int id){
        String sqlDelete = "delete from organization where id = ?";
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
        OrganizationDAO organizationDAO = new OrganizationDAO();
        //insertion
        //organizationDAO.addOrganization("OU College Store", "Sells tennis bats");
        //update
        //organizationDAO.updateOrganization(1,"Srijan Automobiles", "Sells BMW");
        //deletion
        //organizationDAO.deleteOrgnization(7);
        //fetching
        organizationDAO.display();
    }
}
