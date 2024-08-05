package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {
	
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","OnePlus AC2001");
		capabilities.setCapability("platformname", "Android");     
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("platformversion", "12");

		capabilities.setCapability("appPackage","com.google.android.dialer");
		capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");



		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Application Started");



		//click dial pad
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();

		//com.google.android.dialer:id/one
		//  com.google.android.dialer:id/dialpad_voice_call_button

		//9875
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();

		//Click to delete/clear button
		WebElement pressKey=driver.findElement(By.xpath("//android.width.ImageButton[@content-desc=\"backspace\"]"));
		pressKey.click();

		//Call long press() for clear all digit by long press
		longPress(pressKey);

		driver.quit();
	}

	static void longPress(WebElement el)
	{
		Point location=el.getLocation();
		PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH,"finger1");
		Sequence sequence = new Sequence (finger1, 1)
		.addAction (finger1.createPointerMove (Duration.ofMillis(00), PointerInput.Origin.viewport(), location.x,location.y))

		//finger coming down to contact with screen
		.addAction (finger1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
		
		// Long press on clear button
		.addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), location.x,location.y))
		
		//move the finger up
		.addAction (finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(sequence));

	}

}
