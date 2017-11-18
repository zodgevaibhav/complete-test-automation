package com.suite.commons;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import com.suite.commons.library.ExcelReader;


public class TestDataProvider {
	private static String DataArray[][]=null;
	public static String[][] GetExcelDataProvider(Method m){
		System.out.println(getFilePath(m.getDeclaringClass())+"."+m.getName());
		try {
			System.out.println("*************** Looking for excel file "+getFilePath(m.getDeclaringClass()));
			DataArray = ExcelReader.getExcelTableArray(getFilePath(m.getDeclaringClass()),m.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DataArray;
	}

	public static String[][] GetXMLDataProvider(Method m){
		System.out.println(m.getDeclaringClass().getName()+"."+m.getName());
		DataArray = new String[][] {{ "xmlVaibhav", "vz@123" }, { "xmlSwara", "sw@123" }};
		return DataArray;
	}
	
	public static String[][] GetDataBaseDataProvider(Method m){
		System.out.println(m.getDeclaringClass().getName()+"."+m.getName());
		DataArray = new String[][] {{ "DataBasevaibhav", "vz@123" }, { "DataBaseSwara", "sw@123" }};
		return DataArray;
	}
	
	private static String getFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		try {
			strSourceClassName = URLDecoder.decode(strSourceClassName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strFilePath = new StringBuffer();
		strFilePath.append(strSourceClassName.subSequence(1, strSourceClassName.indexOf("com")));
		strFilePath.append(cls.getName().replace(".","/"));
		strFilePath.append(".xlsx");
		System.out.println("Class path is - "+strFilePath);
		//return strFilePath.toString();
		return strSourceClassName.replace(".class", ".xlsx");
	}
}