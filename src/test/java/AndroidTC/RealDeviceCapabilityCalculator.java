package AndroidTC;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AndroidBaseClass_DC.BaseClassForRealDevice;
import io.appium.java_client.android.AndroidDriver;

public class RealDeviceCapabilityCalculator extends BaseClassForRealDevice
{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver driver=Capabilities("real");
		
		//click on number 8
		WebElement num8 =  driver.findElement(By.id("com.oneplus.calculator:id/digit_8"));
		num8.click(); //perform click action on number 8

		//click on plus sign
		WebElement plus =  driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
		plus.click(); //perform click action on number 8

		//click on number 2
		WebElement num2 =  driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
		num2.click(); //perform click action on number 8


		//click on equal sign
		WebElement equal =  driver.findElement(By.id("com.oneplus.calculator:id/eq"));
		equal.click(); //perform click action on number 8


		//click on result sign
		WebElement result =  driver.findElement(By.id("com.oneplus.calculator:id/result"));
		String resultString = result.getText();

		if(resultString.equals("10"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fail");
		}
	}

}
