package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class BrowserAutomation 
{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName","emulator-5554");
		//capabilities.setCapability("appium:browserName", "Chrome");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		//URL url=new URL("http://127.0.0.1.4723/");

		AndroidDriver driver = new AndroidDriver(url, capabilities);		

		driver.get("https://www.cricbuzz.com");

		//find Menu button
		driver.findElement(AppiumBy.xpath("//a[@href='#menu']")).click();
		
		//Find Home button
		driver.findElement(AppiumBy.cssSelector("a[title='Crickbuzz Home']")).click();
		
		//Get title of the page
		System.out.println(driver.getCurrentUrl());
		
		//Scroll page 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBY(0,400)");
		
		//Check if Top Stories is header or not
		WebElement topStories=driver.findElement(AppiumBy.xpath("//h4[@text()='Top Stories']"));
		Assert.assertTrue(topStories.getAttribute("class").contains("header"));

		Thread.sleep(3000);
		driver.quit();


	}

}
