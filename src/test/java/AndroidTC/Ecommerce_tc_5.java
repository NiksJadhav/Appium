package AndroidTC;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import AndroidBaseClass_DC.Ecommerce_Desired_Capabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Ecommerce_tc_5 extends Ecommerce_Desired_Capabilities
{
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		WebElement checkbpox=driver.findElement(By.className("android.widge.checkbox"));
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbpox))).perform();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//Swtich To WebView
		//Verify if user can do operations on webview & can navigate to back to native app	
		Set<String> contexts=driver.getContextHandles();
		for(String contextName: contexts)
		{
			System.out.println(contexts);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.id("q")).sendKeys("Hello");
		driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
		
		driver.navigate().back();
		
		driver.context("NATIVE_APP");

	}

}
