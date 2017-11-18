package com.suite.abstract_tests;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.test.ApiTestSuiteCreator;
import com.api.test.TestInstance;
import com.suite.commons.TestDataProvider;

public class AbstractAPITest {

	@DataProvider(name = "ExcelAPIDataProvider")
	public String[][] DataProvider(Method m) {
		return TestDataProvider.GetExcelDataProvider(m);
	}
	
	@DataProvider(name = "IndependentAPIDataProvider")
	public Iterator<TestInstance[]> independentAPIDataProvider() throws Exception {
		return ApiTestSuiteCreator.createTestSuiteFromDataArray();
	}	
}
