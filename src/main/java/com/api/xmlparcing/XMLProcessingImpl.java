package com.api.xmlparcing;

import org.dom4j.Document;

public class XMLProcessingImpl implements XMLProcessing {

	public Document preProcess(Document xmlTemplate, String[] arrPreProcessXpaths) {
		for (String prePro : arrPreProcessXpaths) {
			if (!prePro.trim().isEmpty()) {
				if (isNodePresent(xmlTemplate, prePro.substring(1, prePro.indexOf("->")))) {
					xmlTemplate.selectSingleNode(prePro.substring(1, prePro.indexOf("->")))
							.setText(prePro.substring(prePro.indexOf("->") + 2, prePro.length()));
				} else {
					System.out.println("Xpath - " + prePro.substring(1, prePro.indexOf("->")) + " not present");
				}
			}
		}
		return xmlTemplate;
	}

	public Document postProcess(Document xmlTemplate, String[] arrPostProcessXpaths) {
		for (String prePro : arrPostProcessXpaths) {
			if (!prePro.trim().isEmpty()) {
				if (isNodePresent(xmlTemplate, prePro.substring(1, prePro.indexOf("->")))) {
					System.out
							.println(xmlTemplate.selectSingleNode(prePro.substring(1, prePro.indexOf("->"))).getText());
				} else {
					System.out.println("Xpath - " + prePro.substring(1, prePro.indexOf("->")) + " not present");
				}
			}
		}
		return null;
	}

	public Document compairEquals(Document xmlTemplate, String[] arrCompairXpaths) {
		for (String prePro : arrCompairXpaths) {
			if (!prePro.trim().isEmpty()) {
				if (isNodePresent(xmlTemplate, prePro.substring(1, prePro.indexOf("->")))) {
					if (xmlTemplate.selectSingleNode(prePro.substring(1, prePro.indexOf("->"))).getText()
							.contentEquals(prePro.substring(prePro.indexOf("->") + 2, prePro.length()))) {
						System.out.println(prePro.substring(1, prePro.indexOf("->")) + " match expected value as - "
								+ prePro.substring(prePro.indexOf("->") + 2, prePro.length()));
					} else {
						System.out.println(
								prePro.substring(1, prePro.indexOf("->")) + " does not match expected value as - "
										+ prePro.substring(prePro.indexOf("->") + 2, prePro.length()));
					}
				} else {
					System.out.println("Xpath - " + prePro.substring(1, prePro.indexOf("->")) + " not present");
				}
			}
		}
		return null;
	}

	private static boolean isNodePresent(Document doc, String strXpath) {
		if (doc.selectSingleNode(strXpath) != null) {
			return true;
		} else {
			return false;
		}
	}
}