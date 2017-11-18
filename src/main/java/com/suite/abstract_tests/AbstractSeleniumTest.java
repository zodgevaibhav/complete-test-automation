package com.suite.abstract_tests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.suite.commons.TestDataProvider;

public class AbstractSeleniumTest {
	
	@DataProvider(name = "ExcelAPIDataProvider")
	public String[][] DataProvider(Method m) {
		return TestDataProvider.GetExcelDataProvider(m);
		//return TestDataProvider.GetExcelDataProvider(m);
	}

}
