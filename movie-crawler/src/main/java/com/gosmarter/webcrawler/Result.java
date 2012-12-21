package com.gosmarter.webcrawler;

import javax.xml.bind.annotation.XmlAttribute;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Result {

	@XmlAttribute(name = "xpath")
	public String getXpath() {
		// TODO Auto-generated method stub
		return xpath;
	}

	@XmlAttribute(name = "property")
	public String getProperty() {
		// TODO Auto-generated method stub
		return property;
	}

	@XmlAttribute(name = "fromsource")
	public String getFromsource() {
		// TODO Auto-generated method stub
		return fromsource;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setFromsource(String fromsource) {
		this.fromsource = fromsource;
	}

	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String xpath;
	private String property;
	private String fromsource;
	private String type;
	HtmlPage htmlPage;
}
