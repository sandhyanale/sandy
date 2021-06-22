package com.crm.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 * this class contains methods related to database
 * @author Chaitra
 *
 */

public class DatabaseUtility {
	
	Connection con=null;
	ResultSet result = null;
	
	/**
	 * this method will establish connection with database
	 * @throws SQLException 
	 */
	public void connectToDB() throws SQLException
	{
		Driver driverRef;
		try
		{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close database connection
	 * @throws SQLException 
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method helps to verify data in database
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int columnName, String expData) throws SQLException
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verfied in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verfied");
			return expData;
		}
	}
	
	public ResultSet readDataFromDatabase()
	{
		//step1
		//step2
		//step3
		//step4
		return result;
	}
	
	
	
	
	
}
