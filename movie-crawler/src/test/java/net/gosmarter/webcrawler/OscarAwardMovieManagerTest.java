package net.gosmarter.webcrawler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.OscarAwardMovieManager;

public class OscarAwardMovieManagerTest {

	OscarAwardMovieManager oscarAwardMovieManager = new OscarAwardMovieManager();

	@Test
	public void testMovieList() throws IOException {
		AwardYear awardYear = new AwardYear("acadamy_award", "/wiki/84th_Academy_Awards", "2012");
		List<AwardMovie> awardMovieList = oscarAwardMovieManager.getList(awardYear);

		assertTrue(0 < awardMovieList.size());
		assertTrue(AwardCrawlInvokar.isNumeric(awardMovieList.get(0).getYear()));
	}
}
