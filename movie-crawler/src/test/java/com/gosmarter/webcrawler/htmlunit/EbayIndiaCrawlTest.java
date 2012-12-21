package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.gosmarter.webcrawler.Item;

import org.apache.log4j.Logger;
import org.junit.Test;

public class EbayIndiaCrawlTest {

	Logger logger = Logger.getLogger(EbayIndiaCrawlTest.class);

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-ebay-iphones.xml";
	
	@Test
	public void testYearList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> bikesList = webCrawlerManager.getList("ebayIphones");

		assertTrue(0 < bikesList.size());
		assertEquals("Apple iPhone 5 (Latest Model) - 16GB - Black&Slate Smar...", ((Item)bikesList.get(0)).getName());
	}
}
