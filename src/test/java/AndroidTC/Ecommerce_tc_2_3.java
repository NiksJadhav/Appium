package AndroidTC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import AndroidBaseClass_DC.Ecommerce_Desired_Capabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Ecommerce_tc_2_3 extends Ecommerce_Desired_Capabilities
{
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		driver=capabilities();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addToCart();
		verifyProductInCheckoutPage();
	}
	public static void addToCart()
	{
		// TC 2 Add product to cart by scrolling to specific product 
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//*[text()='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//*[text()='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"));
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();
		for(int i=0;i<count;i++)
		{
			String product=driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).get(i).getText();
			if(product.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	}
	
	public static void verifyProductInCheckoutPage() throws InterruptedException
	{
		//TC 3 which verify selected product is display in checkout page
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//*[text()='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.xpath("//*[text()='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"));
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();
		for(int i=0;i<count;i++)
		{
			String product=driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).get(i).getText();
			if(product.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);

		String ProductName=driver.findElement(By.id("com.androidsample.generalstore:id/ProductName")).getText();
		
		Assert.assertEquals("Jordan 6 Rings", ProductName);
	}
}