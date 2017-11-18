package com.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.suite.commons.library.ExcelReader;

public class ApiTestSuiteCreator {
	
	public static Iterator<TestInstance[]> createTestSuiteFromDataArray() throws Exception
	{
		String[][] arrData = ExcelReader.getExcelTableArray("C:\\Users\\vaibhavzodge\\git\\Hive\\complete-test-automation\\src\\test\\java\\com\\api\\rest\\test\\SaleMessageTest.xlsx","TEST_SUITE");
		List<TestInstance[]> li = new ArrayList<TestInstance[]>();
		 
		Map<String,String> tempMp = new HashMap<String, String>();
		
		for(int i=1;i<arrData.length;i++)
		{
			TestInstance[] ti= new TestInstance[1];
			for(int j =0;j<arrData[i].length;j++)
			{
				
				tempMp.put(arrData[0][j],arrData[i][j]);
			}
			ti[0]=new TestInstance(i,tempMp);
			li.add(ti);
		}
						
		return li.iterator();
	}

}
