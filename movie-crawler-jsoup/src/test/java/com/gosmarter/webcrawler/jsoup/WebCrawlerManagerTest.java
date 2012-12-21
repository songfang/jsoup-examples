package com.gosmarter.webcrawler.jsoup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class WebCrawlerManagerTest {

	private static Log logger = LogFactory.getLog(WebCrawlerManagerTest.class);
	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "jsoup/webscrap-sample-map.xml";
	
	@Test
	public void testGetList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> movies = webCrawlerManager.getList("movie");
		assertTrue(movies.size() > 0);
		
		assertEquals("Hum Aapke Hain Kaun", ((Movie)movies.get(0)).getName());
		assertEquals("Sooraj R. Barjatya", ((Movie)movies.get(0)).getDirector());
		logger.debug(((Movie)movies.get(0)).getStarring());
		assertTrue(((Movie)movies.get(0)).getStarring().contains("Salman Khan"));
	}

	@Test
	public void testLoadWebCrawlConfig() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		assertNotNull(webCrawlerMapList);
		assertNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(0).getFromsource());
		assertNotNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getFromsource());
	}

}
