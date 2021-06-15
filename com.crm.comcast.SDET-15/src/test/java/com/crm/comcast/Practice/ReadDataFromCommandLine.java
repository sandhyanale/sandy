package com.crm.comcast.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromCommandLine {
	
	@Test
	public void readDataTest() {
		String browserType=System.getProperty("BROWSER");
		String url=System.getProperty("URL");
		System.out.println(browserType);
		System.out.println(url);
		WebDriver driver = null;
		if(browserType.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserType.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(driver==null)
		{
			System.out.println("Browser name is not valid");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		List<WebElement>  links=driver.findElements(By.tagName("a"));
		for(WebElement link:links) {
			System.out.println(link.getAttribute("href"));
		}
		driver.close();
	}
	
	@Test
	public void testCase1() {
		System.out.println("Run Testcase 1");
	}
	
	@Test
	public void testCase2() {
		System.out.println("Run Testcase 2");
	}
	@Test
	public void testCase3() {
		System.out.println("Run Testcase 3");
	}



}
