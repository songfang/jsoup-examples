package com.gosmarter.webcrawler.jsoup;

import java.util.Iterator;

import javax.xml.bind.annotation.XmlAttribute;

import org.jsoup.nodes.Element;

public class Result {

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

	@XmlAttribute(name = "cssselector")
	public String getCssselector() {
		return cssselector;
	}

	public void setCssselector(String cssselector) {
		this.cssselector = cssselector;
	}

	@XmlAttribute(name = "index")
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	private String property;
	private String fromsource;
	private String type;
	private String cssselector;
	private String index;
}
