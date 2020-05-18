package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
	public static void main(String[] args) throws ClassNotFoundException{
		DB_Connection obj_DB_Connection = new DB_Connection();
		System.out.println(obj_DB_Connection.get_connection());
	}
	
	public Connection get_connection() throws ClassNotFoundException{
		Connection connection = null;
try {
		 Class.forName("com.mysql.jdbc.Driver");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","test");		    
	  }
	  catch(SQLException e) {
	    System.out.println(e);
	  }
   return connection;
}
}
