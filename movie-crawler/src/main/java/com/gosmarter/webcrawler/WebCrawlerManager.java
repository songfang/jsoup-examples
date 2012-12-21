package com.gosmarter.webcrawler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebCrawlerManager {

	private static Logger logger = Logger.getLogger(WebCrawlerManager.class);

	private static WebCrawlerMapList webCrawlerMapList = null;

	public List<Object> getList(String id) throws Exception {
		ArrayList<Object> list = new ArrayList<Object>();

		if (webCrawlerMapList == null) {
			webCrawlerMapList = loadWebCrawlConfig();
		}
		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap(id);

		final WebClient webClient = new WebClient();
		final HtmlPage startPage = webClient.getPage(webCrawlerMap.getUrl());

		int startIndex = getStartIndex(webCrawlerMap);

		int index = 0;
		for (int i = 0; i < getEndIndex(webCrawlerMap); i++) {
			index++;
			if (index < startIndex) {
				continue;
			}
			Object obj = setData(startPage, webCrawlerMap, index);
			if (obj == null) {
				break;
			}

			list.add(obj);
		}
		return list;
	}

	WebCrawlerMapList loadWebCrawlConfig() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(WebCrawlerMapList.class);

		Unmarshaller u = jc.createUnmarshaller();

		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("webscrap-map.xml");
		return (WebCrawlerMapList) u.unmarshal(in);
	}

	Object setData(final HtmlPage startPage, WebCrawlerMap webCrawlerMap, int index) throws Exception {
		Class cls = Class.forName(webCrawlerMap.getClassName());
		Object obj = cls.newInstance();

		for (Result result : webCrawlerMap.getResults()) {
			String actualXpath = getActualXpath(result.getXpath(), index);
			List<DomNode> nodes = null;
			if (result.getFromsource() == null) {
				nodes = (List<DomNode>) startPage.getByXPath(actualXpath);
			} else {
				String data = BeanUtils.getProperty(obj, result.getFromsource());
				if(result.htmlPage == null){
					WebClient webClient = new WebClient();
					HtmlPage startPage1 = webClient.getPage(data);
					result.htmlPage = startPage1;
				}
				nodes = (List<DomNode>) result.htmlPage.getByXPath(actualXpath);
			}
			if (nodes.size() == 0) {
				return null;
			}
			for (DomNode node : nodes) {
				logger.debug(node.getNodeName() + " ***** " + node.getNodeValue());
				String data = node.getNodeValue();
				if(result.getType() != null){
					data = getBaseUrl() + node.getNodeValue();
				}
				BeanUtils.setProperty(obj, result.getProperty(), data);
				break;
			}
		}
		return obj;
	}

	private String getBaseUrl() {
		return "http://en.wikipedia.org";
	}

	private String getActualXpath(String xpath, int index) {
		return xpath.replace("?", String.valueOf(index));
	}

	int getStartIndex(WebCrawlerMap webCrawlerMap) {
		return Integer.parseInt(webCrawlerMap.getIndexRange());
	}

	int getEndIndex(WebCrawlerMap webCrawlerMap) {
		return Integer.MAX_VALUE;
	}
}
