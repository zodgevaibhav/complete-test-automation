package com.api.test;

public class RequestTemplate {

	private String xmlTemplate;
	private String jsonTemplate;
	private String templateName;
	private String messageName;
	
	
	public RequestTemplate(String messageName, String templateName,String xmlTemplate, String jsonTemplate)
	{
		setMessageName(messageName);
		setTemplateName(templateName);
		setXmlTemplate(xmlTemplate);
		setJsonTemplate(jsonTemplate);
	}
	
	public String getXmlTemplate() {
		return xmlTemplate;
	}
	private void setXmlTemplate(String xmlTemplate) {
		this.xmlTemplate = xmlTemplate;
	}
	public String getJsonTemplate() {
		return jsonTemplate;
	}
	private  void setJsonTemplate(String jsonTemplate) {
		this.jsonTemplate = jsonTemplate;
	}
	public String getTemplateName() {
		return templateName;
	}
	private  void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getMessageName() {
		return messageName;
	}
	private  void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	
}
