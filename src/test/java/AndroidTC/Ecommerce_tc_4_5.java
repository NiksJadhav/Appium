package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import AndroidBaseClass_DC.Ecommerce_Desired_Capabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions; 
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import junit.framework.Assert;

public class Ecommerce_tc_4_5 extends Ecommerce_Desired_Capabilities
{
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		AndroidDriver driver=capabilities();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Validating total amount in checkout page
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//*[text()='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		//Hide or Minimize keyboard
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//*[text()='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(AppiumBy.xpath("//*[text()='ADD TO CART']")).get(0).click();
		driver.findElements(AppiumBy.xpath("//*[text()='ADD TO CART']")).get(1).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);

		int count=driver.findElements(By.id("com.androidsample.generalstore:id/ProductPrice")).size();
		double sum=0;
		for(int i=0;i<count;i++)
		{
			String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/ProductPrice")).get(i).getText();
			double amount=getAmount(amount1);
			sum=sum+amount;
		}
		
		System.out.println("Sum of Products:"+sum);


		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalValue=getAmount(total);
		System.out.println("Total value of Products:"+totalValue);

		
		Assert.assertEquals(sum, totalValue);
		
		//TC 5 Mobile Gesture
		WebElement checkbpox=driver.findElement(By.className("android.widge.checkbox"));
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbpox))).perform();
		
		WebElement tc=driver.findElement(By.xpath("//*[@text()='Please read our terms and conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(4))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}

	public static double getAmount(String amount)
	{
		//We get price in $ like $120.65 so we need to remove $ from amount
		amount=amount.substring(1);
				
		//Convert String to Double for adding price
		double amount1Value=Double.parseDouble(amount);
		
		return amount1Value;
				
	}
}
