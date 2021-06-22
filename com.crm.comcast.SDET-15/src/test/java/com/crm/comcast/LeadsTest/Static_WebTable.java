package com.crm.comcast.LeadsTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_WebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr"));

		/**
		 * Print entire table
		 */
		//		for (int i = 1; i <= rows.size(); i++)
		//		{		
		//			for (int j = 1; j <=5; j++) 
		//			{
		//				System.out.print(driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td["+j+"]")).getText());
		//				System.out.print(" ");
		//			}
		//			System.out.println();
		//
		//		}


		/**
		 * print all languages
		 */

		List<WebElement> l1 = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr[*]/td[1]"));

		for (int i = 0; i <l1.size(); i++)
		{
			System.out.println(l1.get(i).getText());
		}




	}

}
