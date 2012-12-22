package com.gosmarter.webcrawler.jsoup;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

public class OscarAwardMovieManagerTest {

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "jsoup/webscrap-oscar.xml";
	private static Logger logger = Logger.getLogger(OscarAwardMovieManagerTest.class);
	
	@Test
	public void testMovieList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		
		WebCrawlerMapList webCrawlerMapList = webCrawlerManager.loadWebCrawlConfig();

		WebCrawlerMap webCrawlerMap = webCrawlerMapList.getWebCrawlerMap("awards");
		webCrawlerMap.setUrl("http://en.wikipedia.org/wiki/84th_Academy_Awards");

		List<Object> awardMovieList = webCrawlerManager.getList(webCrawlerMap);

		assertTrue(0 < awardMovieList.size());
		assertTrue(((AwardMovie)awardMovieList.get(0)).getBestMovie1().contains("The Artist"));
		assertTrue(((AwardMovie)awardMovieList.get(1)).getBestDirector1().contains("Michel Hazanavicius"));
		assertTrue(((AwardMovie)awardMovieList.get(2)).getBestLeadHero1().contains("Jean Dujardin" ));
		assertTrue(((AwardMovie)awardMovieList.get(3)).getBestLeadHeroine1().contains("Meryl Streep"));
	}
	
	@Test
	public void testMovies() throws Exception{
		URL url = new URL("http://en.wikipedia.org/wiki/Hum_Aapke_Hain_Kaun");

		Document doc = Jsoup.parse(url, 50000);

		//                                       html body div#content.mw-body div#bodyContent div#mw-content-text.mw-content-ltr table tbody tr td i a
		Iterator<Element> iterator = doc.select("html body div#content.mw-body div#bodyContent div#mw-content-text.mw-content-ltr table.infobox tbody tr td a").iterator();
		while (iterator.hasNext()) {
			String data = Jsoup.clean(iterator.next().html(), Whitelist.none());
			logger.debug("2. " + data);
		}
		
	}
}
