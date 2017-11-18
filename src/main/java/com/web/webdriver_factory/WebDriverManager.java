package com.web.webdriver_factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	
	protected static WebDriver CreateInstance() throws MalformedURLException{
		WebDriver dr;
		dr = new RemoteWebDriver(new URL(getDerivedHubUrl()),getDerivedCapabilities());		
		return dr;
	}
	
	private static DesiredCapabilities getDerivedCapabilities(){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(System.getProperty("platform").contentEquals("web")){
			capabilities.setBrowserName(System.getProperty("browser"));
	//		capabilities.setVersion(System.getProperty("version"));
		}else if(System.getProperty("platform").contentEquals("mobile")){
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("VERSION", "4.2.2");
			capabilities.setCapability("deviceName", "Emulator");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.android.chrome");
			capabilities.setCapability("appActivity", "com.android.chrome");
		}
		return capabilities;		
	}

private static String getDerivedHubUrl(){
		String hubURL = null;
		if(System.getProperty("platform").contentEquals("web")){
			hubURL = System.getProperty("hubUrl");
		}else if(System.getProperty("platform").contentEquals("mobile")){
			hubURL = System.getProperty("appiumServerURL");
		}
		return hubURL;		
	}
}
