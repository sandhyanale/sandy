package com.crm.comcast.VtigerTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;

public class CreateConatctWithOrganization {
	
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		WebDriver driver;
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		
		int random = jLib.getRandomNumber();
		String URL = pLib.readDataFromPropertyFile("url");
	    String USERNAME = pLib.readDataFromPropertyFile("username");
	    String PASSWORD = pLib.readDataFromPropertyFile("password");
	    String BROWSER = pLib.readDataFromPropertyFile("browser");
	    
	    //launch browser
	    if(BROWSER.equals("chrome")){
	    	driver = new ChromeDriver();
	    }else if(BROWSER.equals("firefox")){
	    	driver = new FirefoxDriver();
	    }else {
	    	driver = new InternetExplorerDriver();
	    }
	    
	    //navigate to the url
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(URL);
	    driver.manage().window().maximize();
	    
	    //navigate to organization
	    driver.findElement(By.linkText("Contacts")).click();
	    
		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("chaitra");
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		//wUtil.switchToWindow(driver, "Accounts");
		
		Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId = it.next();
		       driver.switchTo().window(winId);
		   }
		   
		driver.findElement(By.id("search_txt")).sendKeys("SkillRary_"+random);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("SkillRary_"+random)).click();
		//wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
