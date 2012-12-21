package net.gosmarter.webcrawler;

import static org.junit.Assert.*;
import net.gosmarter.factories.AbstractAwardFactory;
import net.gosmarter.factories.CannesFilmFestivalAwardFactory;
import net.gosmarter.factories.OscarAwardFactory;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardYearManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardYearManager;

public class AbstractFactoryTest {

	@Test
	public void testOscarFactory(){
		AbstractAwardFactory abstractAwardFactory = AbstractAwardFactory.getInstance("Academy Award");
		assertTrue(abstractAwardFactory instanceof OscarAwardFactory);
		
		AwardYearManager awardYearManager = abstractAwardFactory.getAwardYearFactory();
		assertTrue(awardYearManager instanceof OscarAwardYearManager);
		
		AwardMovieManager awardMovieManager = abstractAwardFactory.getAwardMovieFactory();
		assertTrue(awardMovieManager instanceof OscarAwardMovieManager);
	}
	
	@Test
	public void testCannesFactory(){
		AbstractAwardFactory abstractAwardFactory = AbstractAwardFactory.getInstance("Cannes Film Festival");
		assertTrue(abstractAwardFactory instanceof CannesFilmFestivalAwardFactory);
		
		AwardYearManager awardYearManager = abstractAwardFactory.getAwardYearFactory();
		assertTrue(awardYearManager instanceof CannesGoldenPalmsAwardYearManager);
		
		AwardMovieManager awardMovieManager = abstractAwardFactory.getAwardMovieFactory();
		assertTrue(awardMovieManager instanceof CannesGoldenPalmsAwardMovieManager);
	}
}
