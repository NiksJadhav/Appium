package AndroidBaseClass_DC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseClassForRealDevice 
{	
	public static AndroidDriver driver;
	public static AndroidDriver Capabilities(String device) throws MalformedURLException
	{
		

		//Gather Desired capabilities
		//edited
			
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if(device.equals("real"))
		{
			//Desired Capability for Android real device
			capabilities.setCapability("appium:deviceName","Android Device/MyAndroidDevice");
		}
			
		else
		{
			//Desired Capability for Emulator
			capabilities.setCapability("appium:deviceName","Pixel 8");

		}
		
		capabilities.setCapability("appium:automationName","UiAutomator2");
		capabilities.setCapability("appium:platformName", "Android");     
		capabilities.setCapability("appium:platformVersion", "15");
		capabilities.setCapability("appium:appPackage","io.appium.android.apis");
		capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");			

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		//URL url=new URL("http://127.0.0.1.4723/");

		driver = new AndroidDriver(url, capabilities);
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}
}


