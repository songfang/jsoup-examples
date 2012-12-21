package net.gosmarter.webcrawler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardYearManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardYearManager;

public class CannesGoldenPalmsAwardYearManagerTest {
	private static Logger logger = Logger.getLogger(CannesGoldenPalmsAwardYearManagerTest.class);

	CannesGoldenPalmsAwardYearManager cannesAwardYearManager = new CannesGoldenPalmsAwardYearManager();

	@Test
	public void testYearList() throws IOException {
		List<AwardYear> awardYearList = cannesAwardYearManager.getList();

		assertTrue(0 < awardYearList.size());
		assertEquals(OscarAwardYearManager.awardName, awardYearList.get(0).getAwardName());
		logger.debug(awardYearList.get(0).getYear());
		assertTrue(AwardCrawlInvokar.isNumeric(awardYearList.get(0).getYear()));
	}
}
