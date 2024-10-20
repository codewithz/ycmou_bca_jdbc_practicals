package com.codewithz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HighestTemperature {

    public static void main(String[] args) {
        try {
            String url="jdbc:postgresql://localhost:5432/ycmou_sem5";
            String user="postgres";
            String password="admin";

            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(url,user,password);

            String query="Select max(temp) from weather where city='New Delhi' and date between '2016-01-01' and '2016-01-31'";

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            if(rs.next()){
                System.out.println("Highest Temperature for Delhi in January 2016 us "+rs.getFloat(1));

            }
            else{
                System.out.println("No record found");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
