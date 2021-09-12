package com.crm.comcast.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility{
	
	public void Select(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	
	public void Select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void mouseover(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void maximizewin(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementToVisible(WebDriver driver, WebElement element)
	{
		 WebDriverWait ww=new WebDriverWait(driver,20);
		 ww.until(ExpectedConditions.elementToBeClickable(element));
				
	}
	//This method is used to switch from one window to another window
	public void switchToWindow(WebDriver driver, String particalWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winID=it.next();
			String title = driver.switchTo().window(winID).getTitle();
			if(title.contains(title))
			{
				break;
			}
			
		}
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String idorName)
	{
		driver.switchTo().frame(idorName);
	}
	
	public void takeScreenshot(WebDriver driver,String screenShotName) throws Throwable 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./screenshot/"+screenShotName+".PNG");
	    Files.copy(src, dest);
		
	}
	
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}


