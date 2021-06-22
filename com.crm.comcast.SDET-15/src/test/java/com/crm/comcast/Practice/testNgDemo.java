package com.crm.comcast.Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class testNgDemo {
	
	@Test
	public void CreateUser()
	{
		System.out.println("user created successfully");
		Reporter.log("user created");
	}
	
	@Test
	public void ModifyUser()
	{
		System.out.println("user successfully modified");
		Reporter.log("modify User");
	}
	
	@Test
	public void DeleteUser()
	{
		System.out.println("User deleted succesfully");
	}

}
