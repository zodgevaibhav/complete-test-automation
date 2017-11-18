package com.suite.abstract_tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.suite.commons.TestDataProvider;
import com.suite.commons.listeners.EnvironmentDataFactory;

import io.restassured.RestAssured;

@Listeners(com.suite.commons.listeners.RestAPIMethodInvocationListener.class)
public class AbstractRestTest extends RestAssured{

	
	@SuppressWarnings({ "unused", "static-access" })
	private void setBaseUrl() {
		this.baseURI=EnvironmentDataFactory.getBaseUrl();
	}
	
	@DataProvider(name="RestApiDataProvider")
	public String[][] getRestDataProvider(Method m)
	{
		return TestDataProvider.GetExcelDataProvider(m);
	}
}
