package iOS_TC;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import iOSBaseClass_DC.iOSDesiredCapabilities;


public class iOS_Locators extends iOSDesiredCapabilities 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		IOSDriver driver=Capabilities();
		
		driver.findElement(AppiumBy.accessibilityId("Alert View")).click();;
		driver.findElement(By.xpath("//*[@value()='Text Entry']")).click();
		driver.findElement(By.className("XCUIElementTypeField")).sendKeys("Hello");
		driver.findElement(By.name("OK")).click();
	}

}
