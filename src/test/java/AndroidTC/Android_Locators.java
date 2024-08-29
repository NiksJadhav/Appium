package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Android_Locators 
{
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName","emulator-5554");
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		capabilities.setCapability("appium:automationName","UiAutomator2");
		capabilities.setCapability("appium:platformName", "Android");     
		//capabilities.setCapability("app", "C:\\Users\\nikit\\eclipse-workspace\\AppiumTutorial\\apkfile\\ApiDemos-debug.apk");
		capabilities.setCapability("appium:platformVersion", "15");
		capabilities.setCapability("appium:appPackage","io.appium.android.apis");
		capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		//URL url=new URL("http://127.0.0.1.4723/");

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text='Preference']")).click();
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("//android.width.RelativeLayout)[1]")).click();
		driver.findElement(AppiumBy.className("android.width.EditText")).sendKeys("Hello");
		driver.findElements(AppiumBy.className("android.width.Button")).get(1).click();
		driver.findElement(AppiumBy.accessibilityId("id"));
		
		
		//Syntax of AndroidUIAutomator
		//Identify by attribute
		// driver.findElement(MobileBy.AndroidUIAutomator("attribute(\"value\")")
		driver.findElement(AppiumBy.androidUIAutomator("text(\"Views\")"));
		
		//Validate clickable feature for all options(Its property so we can't use  above syntax 
		//i.e. attribute(Value)
		//Identify by property
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().clickable(true)"));

		//Get size of particular property
		List <WebElement> element=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().clickable(true)"));	
		Assert.assertTrue(element.size()>11);
	}

}
