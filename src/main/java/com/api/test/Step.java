package com.api.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Step {

	private String stepName;
	private int stepID, testCaseId;
	private Map<String, String> stepPreProcess = new HashMap<String,String>();
	private Map<String, String>  stepStoreData = new HashMap<String,String>();
	private Map<String, String>  stepAsserions = new HashMap<String,String>();

	public Step(int intTestCaseID, int intStepID, String strPreProcess, String strStoreResponseData,
			String strAssertions) {
		fillPreProcessMap(strPreProcess,intStepID,stepPreProcess);
		fillPreProcessMap(strStoreResponseData,intStepID,stepStoreData);
		fillPreProcessMap(strAssertions,intStepID,stepAsserions);
	}

	private void fillPreProcessMap(String strPreProcess, int repeatIndex, Map<String,String> mapToFill) {
		if(strPreProcess.isEmpty()) return;
		
		String arrPreProcessData[] = strPreProcess.split("\n");
		String keyName="", keyValue="";
		Map<String, String> mp=new HashMap<String,String>();
		for (String strProcess : arrPreProcessData) {
			if (strProcess.replace(" ", "").contains("Step")) {
				keyName = strProcess.replace(" ", "");
			} else {
				keyName = strProcess.split("->")[0];
				keyValue=getStringAccordingToRepeatIndex(strProcess,repeatIndex).replace(keyName+"->", "");
				System.out.println("********** INFO:Key value for preprocess is - "+keyValue);
				mapToFill.put(keyName, keyValue);
			}
			
		}
		System.out.println("********** INFO:PreProcess data for Step:"+repeatIndex+" is "+stepPreProcess);
	}
	
	private String getStringAccordingToRepeatIndex(String strProcess,int repeatIndex ) {
		if(strProcess.split("\\|").length>=repeatIndex)
		{
			return strProcess.split("\\|")[repeatIndex-1];
		}else {
			return strProcess.split("\\|")[0].split("->")[1];
		}
	}

	public String getStepName() {
		return stepName;
	}

	public int getStepID() {
		return stepID;
	}

	public int getTestCaseId() {
		return testCaseId;
	}

	public Map<String, String> getStepPreProcess() {
		return stepPreProcess;
	}

	public Map<String, String> getStepStoreData() {
		return stepStoreData;
	}

	public Map<String, String> getStepAsserions() {
		return stepAsserions;
	}
}
