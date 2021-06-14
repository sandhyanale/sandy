package com.crm.comcast.VtigerTest;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganisationInformationPage;
import com.crm.comcast.objectRepository.OrganisationPage;

@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void createOrgTest() throws Throwable
	{
		//fetch the data
		String OrgName = eLib.getExcelData("sheet1","TC_01","OrgName")+jLib.getRandomNumber();
		
	    //navigate to organizations
	    homePage=new HomePage(driver);
	    homePage.clickOnOrganisationLink();
	    Reporter.log("Navigate to Organisation", true);
	    
	    //navigate to create organization
	    OrganisationPage orgPage=new OrganisationPage(driver);
	    orgPage.createOrg();
	    Reporter.log("Navigate to create Organisation", true);
	    
	    //enter mandatory fields and create organization
	    CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
	    createOrgPage.createOrganisation(OrgName);
	    Reporter.log("Enter mandatory filed & create Organisation", true);
	    
	    //validate
        OrganisationInformationPage orgInfoPage=new OrganisationInformationPage(driver);
        String actualOrgName=orgInfoPage.getOrganisationText();
        Assert.assertTrue(actualOrgName.contains(OrgName));
        Reporter.log("Assertion Succesful", true);
        
	}
	
	@Test
	public void createOrgWithType()
	{
		System.out.println("organization created");
	}

}
