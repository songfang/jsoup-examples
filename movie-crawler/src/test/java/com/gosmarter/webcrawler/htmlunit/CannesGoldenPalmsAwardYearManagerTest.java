package com.gosmarter.webcrawler.htmlunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.gosmarter.webcrawler.AwardYear;

import org.junit.Test;

public class CannesGoldenPalmsAwardYearManagerTest {
	
	WebCrawlerManager webCrawlerManager = new WebCrawlerManager();
	private static String webcrawlerConfog = "webscrap-cannes-goldenpalms.xml";
	
	@Test
	public void testYearList() throws Exception {
		webCrawlerManager.setConfigXml(webcrawlerConfog);
		List<Object> awardYearList = webCrawlerManager.getList("awardyear");

		assertTrue(0 < awardYearList.size());
		assertEquals("1975", ((AwardYear)awardYearList.get(0)).getYear());
	}
}
