package com.gosmarter.webcrawler.jsoup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BikedekhoCrawlTest {

	Logger logger = Logger.getLogger(BikedekhoCrawlTest.class);

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "jsoup/webscrap-bikedekho-bikes.xml";
	
	@Test
	public void testLoadWebCrawlConfig() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		assertNotNull(webCrawlerMapList);
		assertEquals("link", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(0).getProperty());
		assertEquals("name", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(1).getProperty());
		assertEquals("price", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getProperty());
		assertEquals("url", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(0).getType());
		assertEquals("text", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(1).getType());
		assertEquals("text", webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getType());
		assertNotNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getCssselector());
		assertNotNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getCssselector());
	}

	@Test
	public void testYearList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> bikesList = webCrawlerManager.getList("bikeDekhoBikes");

		assertTrue(0 < bikesList.size());
		assertEquals("used Bajaj Avenger Dtsi Bike in Hyderabad", ((Item)bikesList.get(0)).getName());
	}
}
