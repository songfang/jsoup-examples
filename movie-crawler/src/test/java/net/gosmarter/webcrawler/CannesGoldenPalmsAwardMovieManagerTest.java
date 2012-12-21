package net.gosmarter.webcrawler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardMovieManager;

public class CannesGoldenPalmsAwardMovieManagerTest {

	CannesGoldenPalmsAwardMovieManager cannesAwardMovieManager = new CannesGoldenPalmsAwardMovieManager();

	@Test
	public void testMovieList() throws IOException {
		AwardYear awardYear = new AwardYear("cannes_award", "/wiki/1976_Cannes_Film_Festival", "1976");
		List<AwardMovie> awardMovieList = cannesAwardMovieManager.getList(awardYear);

		assertTrue(0 < awardMovieList.size());
		assertTrue(AwardCrawlInvokar.isNumeric(awardMovieList.get(0).getYear()));
	}
}
