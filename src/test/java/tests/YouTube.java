package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube 
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		FluentWait<RemoteWebDriver> f=new FluentWait<RemoteWebDriver>(driver);
		f.withTimeout(Duration.ofSeconds(15));
		f.pollingEvery(Duration.ofMillis(1000));
		driver.get("https://www.youtube.com/watch?v=HxnwTUmZ9Zs");
		WebElement e=f.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='segmented-like-button'])[1]/descendant::button")));
		String x = e.getAttribute("aria-label");
		String y=x.replaceAll("[^0-9]","");
		System.out.println("No.Of.Likes : "+y);
		try{driver.close();}catch(Exception ex) {}
	}
}
