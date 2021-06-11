package com.crm.comcast.GenericUtils;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public JSONFileUtility jsLib = new JSONFileUtility();
	public XMLFileUtility xLib =  new XMLFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeTest","regressionTest"})
	public void makeDBConnection() throws Throwable
	{
		//dLib.connectToDB();
		System.out.println("========make database connection=====");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"SmokeTest" ,"regressionTest"})
	public void launchBrowser() throws Throwable
	{
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		
	}
	
	
	@BeforeMethod(groups = {"SmokeTest" , "regressionTest"})
	public void loginTtoApp() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String URL = pLib.readDataFromPropertyFile("url");
		
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		wLib.maximiseWin(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	}
	
	
    @AfterMethod(groups = {"SmokeTest","regressionTest"})
    public void logoutOfApp()
    {
    	WebElement logoutImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wLib.mouseOver(driver, logoutImg);
        wLib.waitForPageToLoad(driver);
        wLib.waitForElementToBeVisible(driver, logoutImg);
        driver.findElement(By.linkText("Sign Out")).click();
    }
    
    @AfterClass(groups = {"SmokeTest" , "regressionTest"})
    public void closeBrowser()
    {
    	driver.close();
    }
    
    @AfterSuite(groups = {"SmokeTest","regressionTest"})
    public void closeDB() throws Throwable
    {
    	//dLib.closeDB();
    	System.out.println("=====close the DB connection======");
    }

}
