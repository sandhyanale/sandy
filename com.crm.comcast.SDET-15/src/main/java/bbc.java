import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bbc 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//typecasting
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,10000)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-10000)");
		
		

	}
}
