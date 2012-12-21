package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.gosmarter.webcrawler.Movie;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gosmarter.webcrawler.htmlunit.WebCrawlerManager;
import com.gosmarter.webcrawler.htmlunit.WebCrawlerMapList;

public class WebCrawlerManagerTest {

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-sample-map.xml";
	
	@Test
	public void testGetList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> movies = webCrawlerManager.getList("movie");
		assertTrue(movies.size() > 0);
		
		assertEquals("Hum Aapke Hain Kaun", ((Movie)movies.get(0)).getName());
		assertEquals("Sooraj R. Barjatya", ((Movie)movies.get(0)).getDirector());
		assertEquals("Madhuri Dixit", ((Movie)movies.get(0)).getStarring());
	}

	@Test
	public void testLoadWebCrawlConfig() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		assertNotNull(webCrawlerMapList);
		assertEquals(2, webCrawlerMapList.getWebCrawlerMap().get(0).getStartIndex());
		assertNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(0).getFromsource());
		assertNotNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getFromsource());
	}

	@Test
	public void testSetData() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();
		
		assertNotNull(webCrawlerMapList);

		final WebClient webClient = new WebClient();
		final HtmlPage startPage = webClient.getPage(webCrawlerMapList.getWebCrawlerMap().get(0).getUrl());
		
		Movie movie = (Movie)webCrawlerManager.setData(startPage, webCrawlerMapList.getWebCrawlerMap().get(0), 2);
		
		assertEquals("Hum Aapke Hain Kaun", movie.getName());
		assertEquals("Sooraj R. Barjatya", movie.getDirector());
		assertEquals("Madhuri Dixit", movie.getStarring());
	}
}
