package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import  io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropDemo 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
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

		//find view button
		WebElement viewBtn =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		viewBtn.click(); //perform click action on view button

		//find drag and drop button
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();

		WebElement source =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));

		WebElement destination =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));


		//By using touch action class
		TouchAction action = new TouchAction(driver);

		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();

		//OR
		/*action.longPress(ElementOption.element(source))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .moveTo(ElementOption.element(destination))
        .release()
        .perform();*/
		
		Thread.sleep(2000);
		driver.quit();//CLOSE SESSION
	}

}
