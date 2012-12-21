package com.gosmarter.webcrawler;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.xml.bind.JAXBException;

import net.gosmarter.webcrawler.Movie;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebCrawlerManagerTest {

	private static Logger logger = Logger.getLogger(WebCrawlerManagerTest.class);

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();

	@Test
	public void testGetList() throws Exception {
		List<Object> movies = webCrawlerManager.getList("movie");
		assertTrue(movies.size() > 0);
		
		assertEquals("Hum Aapke Hain Kaun", ((Movie)movies.get(0)).getName());
		assertEquals("Sooraj R. Barjatya", ((Movie)movies.get(0)).getDirector());
		assertEquals("Madhuri Dixit", ((Movie)movies.get(0)).getStarring());
	}

	@Test
	public void testLoadWebCrawlConfig() throws Exception {
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		assertNotNull(webCrawlerMapList);
		assertEquals("2", webCrawlerMapList.getWebCrawlerMap().get(0).getIndexRange());
		assertNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(0).getFromsource());
		assertNotNull(webCrawlerMapList.getWebCrawlerMap().get(0).getResults().get(2).getFromsource());
	}

	@Test
	public void testSetData() throws Exception {
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
