package com.api.xmlparcing;

import org.dom4j.Document;

public interface XMLProcessing {

	
	public Document preProcess(Document xmlTemplate,String[] arrPreProcessXpaths);
	public Document postProcess(Document xmlTemplate,String[] arrPreProcessXpaths);
	public Document compairEquals(Document xmlTemplate,String[] arrPreProcessXpaths);


}
