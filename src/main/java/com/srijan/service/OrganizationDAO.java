package com.srijan.service;

import java.sql.*;

public class OrganizationDAO {

    public void display(){
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnectio();
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

    public void addOrganization(String orgName, String desc){
        String sqlInsert = "insert into organization (org_name, description) values(?, ?)";
        MySqlDBConnection mySqlDBConnection = new MySqlDBConnection();
        Connection connection = mySqlDBConnection.getDBConnectio();
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

    public static void main(String[] args){
        OrganizationDAO organizationDAO = new OrganizationDAO();
        organizationDAO.addOrganization("OU College Store", "Sells tennis bats");
        organizationDAO.display();
    }
}
