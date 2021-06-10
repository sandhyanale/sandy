package com.crm.comcast.VtigerTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.WebDriverUtility;



public class CreateOrganizationWithIndustry {
	
	@Test
	public void createOrgWithIndustry() throws Throwable
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
	    
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("SkillRary_"+random);

		//Select finance from industry drop-down

		WebElement element = driver.findElement(By.name("industry"));
		wLib.select(element, "Finance");
				
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
