package iOS_TC;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import iOSBaseClass_DC.iOSDesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class Scrolling extends iOSDesiredCapabilities 
{

	public static void main(String[] args) throws MalformedURLException 
	{
		IOSDriver driver=Capabilities();
		
		driver.findElement(AppiumBy.accessibilityId("Alert View")).click();;
		driver.findElement(By.xpath("//*[@value()='Text Entry']")).click();
		driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("Hello");
		driver.findElement(By.name("OK")).click();
		driver.navigate().back();
		
		Dimension size=driver.manage().window().getSize();
		int X=size.getWidth()/2;
		int SY=(int)(size.getHeight()*0.60);
		int EY=(int)(size.getHeight()*0.60);
		driver.swipe(X,SY,X,EY,2000);
		
		/* OR
		TouchAction action=new TouchAction(driver);
		int StartX=driver.manage().window().getSize().width/2;
		int StartY=(int)(driver.manage().window().getSize().height*0.8);
		int EndY=(int)(driver.manage().window().getSize().height*0.2);
		
		action.press(PointOption.point(StartX,StartY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
		.moveTo(StartX,EndY)
		.release()
		.perform();
		
		*/
		
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();;
		
		driver.findElement(By.className("Increament")).click();
		driver.findElement(By.className("Increament")).click();
		
		System.out.println(driver.findElements(By.className("XCITELementTypeStaticText")).get(1).getText());
		
		System.out.println(driver.findElements(By.className("XCITELementTypeStaticText")).get(2).getText());
		driver.findElement(By.className("decreament")).click();

		System.out.println(driver.findElements(By.className("XCITELementTypeStaticText")).get(1).getText());

		driver.navigate().back();
		
		//DropDown Functioanlity
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElements(By.name("Green color component value")).get(0).sendKeys("220");
		driver.findElements(By.className("XCUIElementTypePickerWheel")).get(1).sendKeys("50");
		driver.findElements(By.xpath("//*[@name='Blue color component value'")).get(2).sendKeys("130");
		
		

		
	}

}
