package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;
import net.gosmarter.webcrawler.AwardMovie;
import net.gosmarter.webcrawler.AwardYear;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.OscarAwardMovieManager;

public class OscarAwardMovieManagerTest {

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-oscar.xml";
	
	@Test
	public void testMovieList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestMovie");
		webCrawlerMap.setUrl("http://en.wikipedia.org/wiki/84th_Academy_Awards");

		List<Object> awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertEquals("The Artist", ((AwardMovie)awardMovieList.get(0)).getBestMovie1());

		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestDirector");
		webCrawlerMap.setUrl("http://en.wikipedia.org/wiki/84th_Academy_Awards");

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertEquals("Michel Hazanavicius", ((AwardMovie)awardMovieList.get(0)).getBestDirector1());
	
		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestLeadHero");
		webCrawlerMap.setUrl("http://en.wikipedia.org/wiki/84th_Academy_Awards");

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertEquals("Jean Dujardin", ((AwardMovie)awardMovieList.get(0)).getBestLeadHero1());

		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestLeadHeroine");
		webCrawlerMap.setUrl("http://en.wikipedia.org/wiki/84th_Academy_Awards");

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertEquals("Meryl Streep", ((AwardMovie)awardMovieList.get(0)).getBestLeadHeroine1());
	}
}
