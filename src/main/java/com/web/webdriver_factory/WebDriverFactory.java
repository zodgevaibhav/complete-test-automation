package com.web.webdriver_factory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	public static WebDriver webDriver;
	
	public static WebDriver getDriver(){
		return webDriver;		
	}
	public void setDriver() throws MalformedURLException{
		webDriver = WebDriverManager.CreateInstance();		
	}
}
