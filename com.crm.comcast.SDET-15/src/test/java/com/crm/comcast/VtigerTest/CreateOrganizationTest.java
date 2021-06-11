package com.crm.comcast.VtigerTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.WebDriverUtility;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void createOrgTest() throws Throwable
	{
		
	
		//fetch the data
		String OrgName = eLib.getExcelData("sheet1","TC_01","OrgName")+jLib.getRandomNumber();
		
	    //navigate to organizations
	    driver.findElement(By.linkText("Organizations")).click();
	    
	    //navigate to create organization
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
	    //enter mandatory fields and create organization
	    driver.findElement(By.name("accountname")).sendKeys(OrgName);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //validate
        String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        Assert.assertTrue(successMsg.contains(OrgName));
        System.out.println(successMsg);
        
	}
	
	@Test
	public void createOrgWithType()
	{
		System.out.println("organization created");
	}

}
