package AndroidTC;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import AndroidBaseClass_DC.Ecommerce_Desired_Capabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Ecommerce_tc_1 extends Ecommerce_Desired_Capabilities
{
	public static AndroidDriver driver;
	public static void main(String args[]) throws IOException
	{
		driver=capabilities();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginApp();
		 
		WebElement toastmsg=verifyToastMessage();
		Assert.assertEquals("Please enter your name", "toastmsg");
	}

	public static void loginApp() 
	{
		//verify login 
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//*[text()='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		//Hide or Minimize keyboard
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//*[text()='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	public static WebElement verifyToastMessage()
	{
		//TC 1 which verify toast msg for invalid input
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//*[text()='Argentina']")).click();
		driver.findElement(AppiumBy.xpath("//*[text()='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		WebElement ToastMsg=driver.findElement(AppiumBy.xpath("//android.widget.Toast[0]"));
		
		return ToastMsg;
	}
	
}

	

