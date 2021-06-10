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
import com.crm.comcast.GenericUtils.WebDriverUtility;

public class CreateConatctWithOrganization {
	
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		WebDriver driver;
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
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
	    wLib.waitForPageToLoad(driver);
	    driver.get(URL);
	    wLib.maximiseWin(driver);
	    
	    //login to the application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    //navigate to organization
	    driver.findElement(By.linkText("Contacts")).click();
	    
		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("chaitra");
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		
		//switch to child window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys("TYSS32");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("TYSS32")).click();
		
		//switch the control back to parent
		wLib.switchToWindow(driver, "Contacts");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
