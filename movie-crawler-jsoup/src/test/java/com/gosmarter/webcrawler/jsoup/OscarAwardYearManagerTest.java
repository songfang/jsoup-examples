package com.gosmarter.webcrawler.jsoup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class OscarAwardYearManagerTest {

	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "jsoup/webscrap-oscar.xml";
	
	@Test
	public void testYearList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> awardYearList = webCrawlerManager.getList("awardyear");

		assertTrue(0 < awardYearList.size());
		assertEquals("1st Academy Awards", ((AwardYear)awardYearList.get(0)).getYear());
	}
}
