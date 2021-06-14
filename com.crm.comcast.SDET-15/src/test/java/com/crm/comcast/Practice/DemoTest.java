package com.crm.comcast.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepository.LoginPage;

public class DemoTest {
	
	@Test
	public void demoTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.login("admin", "admin");
	}

}
