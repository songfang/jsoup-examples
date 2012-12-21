package net.gosmarter.webcrawler;

import static org.junit.Assert.*;
import net.gosmarter.spring.AwardCrawlInvokar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardYearManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardYearManager;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AwardCrawlerTest {

	@Autowired
	AwardCrawlInvokar awardCrawlInvokar;

	@Test
	public void testAwardCrawler() {
		
		assertTrue(awardCrawlInvokar.getAwardCrawlers().get(0).getAwardYearManager() instanceof OscarAwardYearManager);
		assertTrue(awardCrawlInvokar.getAwardCrawlers().get(0).getAwardMovieManager() instanceof OscarAwardMovieManager);
		assertTrue(awardCrawlInvokar.getAwardCrawlers().get(1).getAwardYearManager() instanceof CannesGoldenPalmsAwardYearManager);
		assertTrue(awardCrawlInvokar.getAwardCrawlers().get(1).getAwardMovieManager() instanceof CannesGoldenPalmsAwardMovieManager);
	}
}
