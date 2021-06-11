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

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.WebDriverUtility;



public class CreateOrganizationWithIndustry extends BaseClass {
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustry() throws Throwable
	{
		
		
		//Fetch the data
		String OrgName = eLib.getExcelData("sheet1", 1,2)+jLib.getRandomNumber();
		String IndustryType = eLib.getExcelData("sheet1",3,3);
	    
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		//Select finance from industry drop-down

		WebElement element = driver.findElement(By.name("industry"));
		wLib.select(element, IndustryType);
				
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
