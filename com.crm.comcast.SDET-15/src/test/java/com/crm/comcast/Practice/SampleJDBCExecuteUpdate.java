package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	@Test
	public void executeUpdateJDBC() throws SQLException
	{
		Connection conn=null;
		try
		{
		//Step 1: Register to database
	    Driver driverRef = new Driver();
	    DriverManager.registerDriver(driverRef);
	    
	    //Step 2: get connection with database- provide database name
	     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
	    
	    //Step 3: issue create statement
	    Statement stat = conn.createStatement();
	  
	    //Step 4: Execute any query - provide table name
	    int result = stat.executeUpdate("insert into employee values('Rajat',1258964,'Delhi');");//execution stopped
	    if(result == 1)
	    {
	    	System.out.println("query successfull- 1 row added");
	    }
	    else
	    {
	    	System.out.println("query failed");
	    }
		}
		catch(Exception e)
		{
			
		}
	    
	    //Step 5: close the database
		finally {
			conn.close();
			System.out.println("database connection closed successfully");
		}
	    
	    
	}
		
	}
