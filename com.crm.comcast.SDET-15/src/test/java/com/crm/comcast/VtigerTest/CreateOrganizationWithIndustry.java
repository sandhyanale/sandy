package com.crm.comcast.VtigerTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganisationInformationPage;
import com.crm.comcast.objectRepository.OrganisationPage;


@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreateOrganizationWithIndustry extends BaseClass {
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustry() throws Throwable
	{
		
		
		//Fetch the data
		String OrgName = eLib.getExcelData("sheet1", 1,2)+jLib.getRandomNumber();
		String IndustryType = eLib.getExcelData("sheet1",3,3);
	    
		//Navigate to organizations
		homePage=new HomePage(driver);
	    homePage.clickOnOrganisationLink();

		//create organization
	    OrganisationPage orgPage=new OrganisationPage(driver);
	    orgPage.createOrg();
	    
	    //enter mandatory fields and create organization
	    CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
	    createOrgPage.createOrganisationWithIndustry(OrgName, IndustryType);
	    
	    //validate
        OrganisationInformationPage orgInfoPage=new OrganisationInformationPage(driver);
        String actualOrgName=orgInfoPage.getOrganisationText();
        Assert.assertTrue(actualOrgName.contains(OrgName));
        String actualIndustryName=orgInfoPage.getIndusInfo();
        Assert.assertEquals(actualIndustryName, IndustryType);
	}

}
