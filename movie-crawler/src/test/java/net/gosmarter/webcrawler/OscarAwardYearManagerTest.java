package net.gosmarter.webcrawler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.OscarAwardYearManager;

public class OscarAwardYearManagerTest {
	OscarAwardYearManager oscarAwardYearManager = new OscarAwardYearManager();

	@Test
	public void testYearList() throws IOException {
		List<AwardYear> awardYearList = oscarAwardYearManager.getList();

		assertTrue(0 < awardYearList.size());
		assertEquals(OscarAwardYearManager.awardName, awardYearList.get(0).getAwardName());
		assertTrue(AwardCrawlInvokar.isNumeric(awardYearList.get(0).getYear()));
	}
}
