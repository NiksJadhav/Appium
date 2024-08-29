package iOSBaseClass_DC;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
public class iOSDesiredCapabilities 
{
	static IOSDriver driver;
	public static IOSDriver Capabilities() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName","iphone 6");
		capabilities.setCapability("appium:platformName", "iOS");
		//If we work on ios version more than 10 then we need to use automationName 
		capabilities.setCapability("appium:automationName",AutomationName.IOS_XCUI_TEST);
		// capabilities.setCapability("appium:automationName","XCUITest");
		capabilities.setCapability("app", "//users//xcodeclub//Desktop//UICatlog.app");
		
		//Below capabilities are for real device 
		capabilities.setCapability("udid","IdOfRealDevice");
		capabilities.setCapability("xcodeOrgId","xcodeofTeamAppleID");
		capabilities.setCapability("xcodeSigningId","iphone Developer");
		capabilities.setCapability("updateWDABundled","BundleID");


		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		//URL url=new URL("http://127.0.0.1.4723/");
		
		driver=new IOSDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
		
	}
}
