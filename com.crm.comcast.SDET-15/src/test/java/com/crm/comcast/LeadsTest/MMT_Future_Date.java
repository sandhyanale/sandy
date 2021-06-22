package com.crm.comcast.LeadsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MMT_Future_Date {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		
//		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
//
//		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
//
//		src.sendKeys("GOA");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click();	
//
//		dest.sendKeys("KOLKATA");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(text(),'CCU')]")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		Thread.sleep(2000);

		int count =0;

		Thread.sleep(2000);

		while(count<=11) 
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Wed Dec 15 2021']")).click();
				break;
			} 
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				count++;
			}
		}




	}

}
