package com.crm.comcast.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.PropertyFileUtility;

public class DynamicWebtable {
	
	@Test
	public void handlingDynamicWebTable() throws Throwable
	{
		WebDriver driver;
		PropertyFileUtility pLib = new PropertyFileUtility();
		
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String URL = pLib.readDataFromPropertyFile("url");
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on all the check boxes
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		
		
        for(int i=1;i<list.size();i++)
        {
        	list.get(i).click();
        }
        
		//click on last check box
		list.get(list.size()-1).click();
        
		//click on 3rd row check box
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input")).click();
		
		//select only first 5 check boxes
		
		//print all organization name in console
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		String expData = "ch";
		int actDataCount =0;
		
		for(WebElement ls : list2)	
		{
			String actData = ls.getText();
			if(expData.equalsIgnoreCase(actData))
			{
				break;
			}
			actDataCount++;
		}
		
		System.out.println(actDataCount);
        driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(actDataCount+2)+"]/td[8]/a[.='del']")).click();
		
		
	}

}
