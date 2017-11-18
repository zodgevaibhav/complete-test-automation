package com.api.test;

import java.util.HashMap;
import java.util.Map;

import com.suite.commons.library.ExcelReader;

public class RequestTemplateFactory {
	private static Map<String,RequestTemplate> requestFactory = new HashMap<String, RequestTemplate>();
	
	public static void updateRequestTemplates() {
		try {
			String[][] arrData = ExcelReader.getExcelTableArray("C:\\Users\\vaibhavzodge\\git\\Hive\\complete-test-automation\\src\\test\\java\\com\\api\\rest\\test\\RequestTemplates.xlsx","TEMPLATES");
			for(int i=1;i<arrData.length;i++)
			{
				requestFactory.put(arrData[i][1], new RequestTemplate(arrData[i][0],arrData[i][1],arrData[i][2],arrData[i][3]));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getXmlTemplate(String templateName)
	{
		return requestFactory.get(templateName).getXmlTemplate();
	}
	
	public static String getJsonTemplate(String templateName)
	{
		return requestFactory.get(templateName).getJsonTemplate();
	}

}
