package com.gosmarter.webcrawler;

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

	@XmlAttribute(name = "indexRange")
	public String getIndexRange() {
		// TODO Auto-generated method stub
		return indexRange;
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

	public void setIndexRange(String indexRange) {
		this.indexRange = indexRange;
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

	private String url;
	private String indexRange;
	private List<Result> results;
	private String className;
	private String id;
}
