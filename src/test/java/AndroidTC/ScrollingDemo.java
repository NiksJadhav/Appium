package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ScrollingDemo 
{

	public static void main(String[] args) throws MalformedURLException 
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
		driver.findElement(AppiumBy.xpath("//android.width.TextView[@text()='View']")).click();
		
		//Touch Action UiSelector only for Android
		TouchAction t=new TouchAction(driver);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//OR
		//Using W3C Actions API
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence scroll = new Sequence(finger, 1);

		// Get the dimensions of the screen
		int screenWidth = driver.manage().window().getSize().width;
		int screenHeight = driver.manage().window().getSize().height;

		// Define start and end points for the scroll (vertical scroll down)
		int startX = screenWidth / 2;
		int startY = (int) (screenHeight * 0.8); // Start slightly from the bottom
		int endX = screenWidth / 2;
		int endY = (int) (screenHeight * 0.2); // End slightly from the top

		// Add actions to the sequence
		scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
		scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the scroll action
		driver.perform(Arrays.asList(scroll));
	}

}
