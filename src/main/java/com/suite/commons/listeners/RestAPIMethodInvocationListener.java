package com.suite.commons.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class RestAPIMethodInvocationListener implements IInvokedMethodListener {

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.isTestMethod())
		{
			EnvironmentDataFactory.setEnvironmentName(System.getProperty("environment"));
		}
		
	}

}
