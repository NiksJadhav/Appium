package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions; 
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import io.appium.java_client.android.AndroidDriver;

public class LongPressGensture 
{
	
	static AndroidDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException 
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
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='View']"));
		
		//Tab Gesture
		TouchAction t=new TouchAction(driver);
		WebElement expandList=driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='ExpandableLists')"));

		t.tap(tapOptions().withElement(element(expandList))).perform();
		
		//Long Press Gesture
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='Custom Adpter')")).click();
		WebElement pn=driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='Pople Names']"));
		
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(Duration.ofSeconds(10))).release().perform();
		
		
		
	}
		
	

}
