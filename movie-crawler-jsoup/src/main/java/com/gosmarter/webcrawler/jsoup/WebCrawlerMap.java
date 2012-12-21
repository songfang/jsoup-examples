package com.gosmarter.webcrawler.jsoup;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class WebCrawlerMap {

	@XmlAttribute(name = "url")
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

	@XmlElement(name = "result")
	public List<Result> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	@XmlAttribute(name = "startIndex")
	public int getStartIndex() {
		// TODO Auto-generated method stub
		return startIndex;
	}

	@XmlAttribute(name = "class")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "baseurl")
	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	@XmlAttribute(name = "endIndex")
	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	@XmlAttribute(name = "data")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private String url;
	private int startIndex;
	private int endIndex;
	private List<Result> results;
	private String className;
	private String id;
	private String baseurl;
	private String data;
}
