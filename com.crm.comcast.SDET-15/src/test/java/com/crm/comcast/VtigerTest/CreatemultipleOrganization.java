package com.crm.comcast.VtigerTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreatemultipleOrganization extends BaseClass {
	
	@DataProvider
    public Object[][] getData() throws Throwable
    {
		return eLib.getExcelData("sheet3");
    }
	
	@Test(dataProvider = "getData")
	public void createMulipleOrg(String OrgName, String IndustryType) throws Throwable
	{
    
    //navigate to organizations
    driver.findElement(By.linkText("Organizations")).click();
    
    //navigate to create organization
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    
    //enter mandatory fields and create organization
    driver.findElement(By.name("accountname")).sendKeys(OrgName);
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    //select industry dropdrown
    WebElement element = driver.findElement(By.name("industry"));
	wLib.select(element, IndustryType);

    //validate
    String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    Assert.assertTrue(successMsg.contains(OrgName));
    System.out.println(successMsg);

}
}
