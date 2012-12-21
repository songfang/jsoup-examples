package com.gosmarter.webcrawler.htmlunit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "webScrapMap")
public class WebCrawlerMapList {
    protected List<WebCrawlerMap> webCrawlerMaps = new ArrayList<WebCrawlerMap>();

	public WebCrawlerMap getWebCrawlerMap(String id) {
		// TODO Auto-generated method stub
		for(WebCrawlerMap w: webCrawlerMaps){
			if(w.getId().equals(id)){
				return w;
			}
		}
		return null;
	}

	@XmlElement(name = "resultMap", required = true)
	public List<WebCrawlerMap> getWebCrawlerMap() {
		return webCrawlerMaps;
	}

	public void setWebCrawlerMap(List<WebCrawlerMap> webCrawlerMaps) {
		this.webCrawlerMaps = webCrawlerMaps;
	}
}
