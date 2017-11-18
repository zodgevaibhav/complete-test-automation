package com.api.rest.test;

import org.testng.annotations.Test;

import com.api.test.RequestTemplateFactory;
import com.api.test.Step;
import com.api.test.TestInstance;
import com.suite.abstract_tests.AbstractAPITest;

public class SaleTest extends AbstractAPITest{

	@Test(dataProvider="IndependentAPIDataProvider")
	public void apiTest(TestInstance test){
		RequestTemplateFactory.updateRequestTemplates();
		
		System.out.println(test.getTestCaseID());
		System.out.println(test.getTestCaseName());
		System.out.println(test.getTestSet());
		System.out.println(test.getRequestType());
		System.out.println(test.getRequestFormat());
		System.out.println(test.getIsRepeatable());
		System.out.println(test.getTemplateName());
		System.out.println("**********  Received XML template in Test is "+RequestTemplateFactory.getXmlTemplate(test.getTemplateName()));
		for(Step step:test.getSteps())
		{
			System.out.println("Step - "+step.getStepPreProcess().toString());
			System.out.println("Step - "+step.getStepStoreData().toString());
			System.out.println("Step - "+step.getStepAsserions().toString());
		}
	}

}
