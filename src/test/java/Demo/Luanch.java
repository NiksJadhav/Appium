package Demo;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Luanch {

	public static void main(String[] args) 
	{
		String str="abcdfabc";
		char[] c=str.toCharArray();
		for(int i=0;i<c.length;i++);
		{
			for(int j=i+1;j<c.length;j++)
			{
				if(c[i]==c[j])
				{
					System.out.println(c[j]);
					break;
				}
			}
		}

	}

}
