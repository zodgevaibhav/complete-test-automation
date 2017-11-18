package com.api.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestInstance {

	private String testCaseID;
	private String testSet;
	private String testCaseName;
	private String stepName;
	private String requestType;
	private String requestFormat;
	private String templateName;
	private String isRepeatable;
	private String preProcess; // for internal use only
	private String storeResponseData;
	private String assertions;
	private int internelTestId=0;

	private List<Step> steps= new ArrayList<Step>();

	public TestInstance(int iTestCaseID,Map<String, String> mapOfTestData) {
		fillTestObject(iTestCaseID,mapOfTestData);
	}

	private void fillTestObject(int iTestCaseID, Map<String, String> mapOfTestData) {
		testCaseID = mapOfTestData.get("testCaseID");
		testSet = mapOfTestData.get("testSet");
		testCaseName = mapOfTestData.get("testCaseName");
		stepName = mapOfTestData.get("stepName");
		requestType = mapOfTestData.get("requestType");
		requestFormat = mapOfTestData.get("requestFormat");
		templateName = mapOfTestData.get("templateName");
		isRepeatable = mapOfTestData.get("isRepeatable");
		internelTestId = iTestCaseID;
		preProcess = mapOfTestData.get("preProcess");
		storeResponseData = mapOfTestData.get("storeResponseData");
		assertions = mapOfTestData.get("assertions");
		fillStepList();
	}

	private void fillStepList() {
		int stepCount = stepName.split("\n").length;
		int stepRepeateCount = 1;
		
		stepRepeateCount=isRepeatable.equals("NO")?1:getMaxRepeatCountFromPreprocessForTest();
																		// Repeat count only depend on preprocess, Repeat
		System.out.println("********** INFO:Repeat count is - "+stepRepeateCount );																// available only for Single Step
		if(stepCount>1 && stepRepeateCount>1)
		{
			System.out.println("********** ERROR:Repeat can be applied to multiple steps, for repeate to use, test must have single step. "+stepRepeateCount );
		}else {
			int stepToCreate = stepCount>stepRepeateCount?stepCount:stepRepeateCount;
			System.out.println("********** INFO:Derived Step or repeate count is "+stepToCreate );
			for(int counter=1;counter<=stepToCreate;counter++)
			{
				steps.add(new Step(internelTestId, counter,preProcess, storeResponseData,assertions));
			}
		}
		System.out.println(steps);
	}

	/**
	 * This function return the repeate test step count
	 * @return
	 */
	private int getMaxRepeatCountFromPreprocessForTest() {
		int maxRepeateCount = 1;
		if (preProcess.contains("|")) {
			String[] arrPreProcessWithVurbaseStep = preProcess.split("\n");
			for (String strTemp : arrPreProcessWithVurbaseStep) {
				if (maxRepeateCount<(strTemp.split("\\|")).length)
					maxRepeateCount = strTemp.split("\\|").length;
			}
		}
			return maxRepeateCount;
	}
	public String getTestCaseID() {
		return testCaseID;
	}

	public String getTestSet() {
		return testSet;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public String getStepName() {
		return stepName;
	}

	public String getRequestType() {
		return requestType;
	}

	public String getRequestFormat() {
		return requestFormat;
	}

	public String getTemplateName() {
		return templateName;
	}

	public String getIsRepeatable() {
		return isRepeatable;
	}

	public String getPreProcess() {
		return preProcess;
	}

	public String getStoreResponseData() {
		return storeResponseData;
	}

	public String getAssertions() {
		return assertions;
	}

	public int getInternelTestId() {
		return internelTestId;
	}

	public List<Step> getSteps() {
		return steps;
	}
}
