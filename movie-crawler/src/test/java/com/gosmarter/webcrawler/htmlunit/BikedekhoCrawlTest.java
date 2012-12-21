package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.gosmarter.webcrawler.Item;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BikedekhoCrawlTest {

	Logger logger = Logger.getLogger(BikedekhoCrawlTest.class);

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-bikedekho-bikes.xml";
	
	@Test
	public void testYearList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> bikesList = webCrawlerManager.getList("bikeDekhoBikes");

		assertTrue(0 < bikesList.size());
		assertEquals("Used Bajaj Avenger Dtsi Bike in Hyderabad", ((Item)bikesList.get(0)).getName());
	}
}
