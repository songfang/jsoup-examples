package com.gosmarter.webcrawler.htmlunit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebCrawlerManager {
	private static Logger logger = Logger.getLogger(WebCrawlerManager.class);

	public List<Object> getList(String id) throws Exception {

		WebCrawlerMapList webCrawlerMapList = loadWebCrawlConfig();

		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap(id);

		return getList(webCrawlerMap);
	}

	public List<Object> getList(WebCrawlerMap webCrawlerMap) throws Exception {
		ArrayList<Object> list = new ArrayList<Object>();
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_10);
		
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

		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(getConfigXml());
		return (WebCrawlerMapList) u.unmarshal(in);
	}

	private String configXml;

	public String getConfigXml() {
		return configXml;
	}

	public void setConfigXml(String configXml) {
		this.configXml = configXml;
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
				if (result.htmlPage == null) {
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
				if (result.getContains() != null) {
					if (node.asText().contains(result.getContains())) {
						BeanUtils.setProperty(obj, result.getProperty(), node.asText());
						break;
					}
				} else {
					String data = node.getNodeValue();
					if (result.getType() != null) {
						data = getBaseUrl(webCrawlerMap) + node.getNodeValue();
					}
					BeanUtils.setProperty(obj, result.getProperty(), data);
					break;
				}
			}
		}
		return obj;
	}

	private String getBaseUrl(WebCrawlerMap webCrawlerMap) {
		return webCrawlerMap.getBaseurl();
	}

	private String getActualXpath(String xpath, int index) {
		return xpath.replace("?", String.valueOf(index));
	}

	int getStartIndex(WebCrawlerMap webCrawlerMap) {
		if (webCrawlerMap.getStartIndex() == 0) {
			return 1;
		}
		return webCrawlerMap.getStartIndex();
	}

	int getEndIndex(WebCrawlerMap webCrawlerMap) {
		if (webCrawlerMap.getEndIndex() == 0) {
			return Integer.MAX_VALUE;
		}
		return webCrawlerMap.getEndIndex();
	}
}
