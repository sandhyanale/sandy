package com.crm.comcast.VtigerTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreateConatctWithOrganization extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		//fetch the data
		String OrgName = eLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		String ContactLastName = eLib.getExcelData("sheet2", "Tc_01", "ContactName");
	 
	    
	    
		
		 //Create Contact with organization
	    wLib.waitForPageToLoad(driver);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		
		//switch to child window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(OrgName)).click();
		
		//switch the control back to parent
		wLib.switchToWindow(driver, "Contacts");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Assert.assertTrue(false);
		
	}
	@Test
	public void skipTest() {
		throw new SkipException("This method will be skipped in excution");
	}

}
