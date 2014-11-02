//package com.mkyong.common;
package is.ru.tictactoe; 

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class JDBCSample {
 
    public static void main(String[] argv) {
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	    System.out.println("Where is your MySQL JDBC Driver?");
	    e.printStackTrace();
	    return;
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
 
	try {
	    connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/Testing","root", "1204922099");
 
	} catch (SQLException e) {
	    System.out.println("Connection Failed! Check output console");
	    e.printStackTrace();
	    return;
	}
 
	if (connection != null) {
	    System.out.println("You made it, take control your database now!");
	} else {
	    System.out.println("Failed to make connection!");
	}
    }
}




/*import java.sql.*;
 
public class JDBCSample {
 
    public static void main( String args[]) {
 
	//String connectionURL = "jdbc:://localhost:3306/Testing;user=root;password=1204922099";
	// Change the connection string according to your db, ip, username and password
 
	String url = "jdbc:mysql://localhost:3306/Testing";
	Connection con = null;

	try {
 
	    // Load the Driver class. 
	    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	    //Class.forName("org.postgresql.Driver");
	    // If you are using any other database then load the right driver here.
	    con = DriverManager.getConnection(url + "user=root&password=1204922099"); 
	    //Create the connection using the static getConnection method

	    //Connection con = DriverManager.getConnection (connectionURL);
 
	    //Create a Statement class to execute the SQL statement
	    Statement stmt = con.createStatement();
 
	    //Execute the SQL statement and get the results in a Resultset
	    ResultSet rs = stmt.executeQuery("select Name from Players");
 
	    // Iterate through the ResultSet, displaying two values
	    // for each row using the getString method
 
	    while (rs.next())
		System.out.println("Name= " + rs.getString("Name"));
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	finally {
	    // Close the connection
	    // con.close();
	}
    }
    }*/








