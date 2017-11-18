package com.suite.commons.listeners;

public class EnvironmentDataFactory {

	private static String environmentName;
	private static String baseUrl;

	public static String getEnvironmentName() {
		return environmentName;
	}

	public static void setEnvironmentName(String environmentName) {
		if(null== environmentName || environmentName.contentEquals("DEV"))
		{
			environmentName = "DEV";
			baseUrl="http://localhost:8080/";
		}
	}
	
	public static String getBaseUrl()
	{
		return baseUrl;
	}
}

