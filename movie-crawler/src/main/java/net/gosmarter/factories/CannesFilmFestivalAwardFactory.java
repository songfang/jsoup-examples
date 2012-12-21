package net.gosmarter.factories;

import net.gosmarter.webcrawler.AwardMovieManager;
import net.gosmarter.webcrawler.AwardYearManager;

import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.CannesGoldenPalmsAwardYearManager;

public class CannesFilmFestivalAwardFactory extends AbstractAwardFactory {

	@Override
	public AwardYearManager getAwardYearFactory() {
		return new CannesGoldenPalmsAwardYearManager();
	}

	@Override
	public AwardMovieManager getAwardMovieFactory() {
		return new CannesGoldenPalmsAwardMovieManager();
	}

}
