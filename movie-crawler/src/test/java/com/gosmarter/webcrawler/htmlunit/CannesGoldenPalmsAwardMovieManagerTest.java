package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.gosmarter.webcrawler.AwardMovie;

import org.junit.Test;

public class CannesGoldenPalmsAwardMovieManagerTest {
	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-cannes-goldenpalms.xml";
	private static String dynaUrl = "http://en.wikipedia.org/wiki/1975_Cannes_Film_Festival";
	
	@Test
	public void testMovieList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestMovie");
		webCrawlerMap.setUrl(dynaUrl);

		List<Object> awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertTrue(((AwardMovie)awardMovieList.get(0)).getBestMovie1().contains("Chronique des Années de Braise"));

		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestDirector");
		webCrawlerMap.setUrl(dynaUrl);

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertTrue(((AwardMovie)awardMovieList.get(0)).getBestDirector1().contains("Costa Gavras"));
	
		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestLeadHero");
		webCrawlerMap.setUrl(dynaUrl);

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertTrue(((AwardMovie)awardMovieList.get(0)).getBestLeadHero1().contains("Vittorio Gassman"));

		webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awardBestLeadHeroine");
		webCrawlerMap.setUrl(dynaUrl);

		awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertTrue(((AwardMovie)awardMovieList.get(0)).getBestLeadHeroine1().contains("Valerie Perrine"));
	}
}
