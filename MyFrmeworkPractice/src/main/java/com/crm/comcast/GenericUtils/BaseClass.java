package com.crm.comcast.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public JSONFileUtility jsLib = new JSONFileUtility();
	public XMLFileUtility xLib =  new XMLFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriver driver;
	
	@BeforeSuite
	public void makeDBconnection()
	{
		
	}
	

}
