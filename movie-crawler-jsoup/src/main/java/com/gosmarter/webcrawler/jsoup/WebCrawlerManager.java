package com.gosmarter.webcrawler.jsoup;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

public class WebCrawlerManager {
	private static Logger logger = Logger.getLogger(WebCrawlerManager.class);

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

	public List<Object> getList(String id) throws Exception {

		WebCrawlerMapList webCrawlerMapList = loadWebCrawlConfig();

		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap(id);

		return getList(webCrawlerMap);
	}

	public List<Object> getList(WebCrawlerMap webCrawlerMap) throws Exception {
		URL url = new URL(webCrawlerMap.getUrl());

		Document doc = Jsoup.parse(url, 50000);
		// Getlist of objects
		List<Object> objects = getObjectLists(doc, webCrawlerMap);
		// for each result object, pass the object list and for each
		// iterator for xpath check the property name and assign the task
		int currentResultIndex = 0;
		for (Result result : webCrawlerMap.getResults()) {
			if (result.getFromsource() == null) {
				setData(doc, webCrawlerMap, result, objects, currentResultIndex++);
			}
		}
		for (Result result : webCrawlerMap.getResults()) {
			if (result.getFromsource() != null) {
				for (Object obj : objects) {
					String linkUrl = BeanUtils.getProperty(obj, result.getFromsource());
					URL url1 = new URL(linkUrl);
					Document doc1 = Jsoup.parse(url1, 50000);
					Element elm = doc1.select(result.getCssselector()).first();
					String data = Jsoup.clean(elm.text(), Whitelist.none());
					BeanUtils.setProperty(obj, result.getProperty(), data);
				}
			}
		}
		return objects;
	}

	private List<Object> getObjectLists(Document doc, WebCrawlerMap webCrawlerMap) throws Exception {
		ArrayList<Object> list = new ArrayList<Object>();
		if (webCrawlerMap.getResults().size() > 0) {
			Iterator<Element> iterator = doc.select(webCrawlerMap.getResults().get(0).getCssselector()).iterator();
			while (iterator.hasNext()) {
				iterator.next();
				Class cls = Class.forName(webCrawlerMap.getClassName());
				Object obj = cls.newInstance();
				list.add(obj);
			}
		}
		return list;
	}

	private void setData(Document doc, WebCrawlerMap webCrawlerMap, Result result, List<Object> object, int currentResultIndex)
			throws Exception {
		Iterator<Element> iterator = doc.select(result.getCssselector()).iterator();
		int index = 0;
		while (iterator.hasNext()) {
			Element element = iterator.next();
			String data = "";
			if (result.getType().equals("url")) {
				data = element.attr("href");
				if (webCrawlerMap.getBaseurl() != null) {
					data = webCrawlerMap.getBaseurl() + element.attr("href");
				}
			} else if (result.getType().equals("img")) {
				data = element.attr("src");
			} else {
				data = element.text();
			}
			if (result.getIndex() == null) {
				BeanUtils.setProperty(object.get(index), result.getProperty(), data);
			} else {
				int resultIndex = Integer.valueOf(result.getIndex());
				if (resultIndex == currentResultIndex && resultIndex == index) {
					BeanUtils.setProperty(object.get(index), result.getProperty(), data);
					break;
				}
			}
			index++;
		}
	}
}
