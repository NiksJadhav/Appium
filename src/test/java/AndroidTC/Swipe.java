
package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Swipe 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
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
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='View']")).click();
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='Date Widgets']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("text(\"2. Inline\")"));
		driver.findElement(AppiumBy.xpath("//*[content-desc()='9']")).click();
		
		//Tap,press,release,scroll,swipe,drag and drop touch action class is used
		TouchAction t=new TouchAction(driver);
		
		//Swipe Gesture
		WebElement source=driver.findElement(By.xpath("//*[@content-desc='15]"));
		source.click();
		
		WebElement destination=driver.findElement(By.xpath("//*[@content-desc='45]"));
		destination.click();


		// Long press on element// wait for sec// Move to another element// release
		t.longPress(longPressOptions()
		.withElement(element(source))
		.withDuration(ofSeconds(10)))
		.moveTo(element(destination))
		.release().perform();
		
		//OR
		t.press(ElementOption.element(source))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .moveTo(ElementOption.element(destination))
        .release()
        .perform();
		
		
		

	}

}
