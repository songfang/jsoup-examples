package net.gosmarter.factories;

import net.gosmarter.webcrawler.AwardMovieManager;
import net.gosmarter.webcrawler.AwardYearManager;

import com.gosmarter.webcrawler.jsoup.OscarAwardMovieManager;
import com.gosmarter.webcrawler.jsoup.OscarAwardYearManager;

public class OscarAwardFactory extends AbstractAwardFactory {

	public AwardYearManager getAwardYearFactory() {
		// TODO Auto-generated method stub
		return new OscarAwardYearManager();
	}

	public AwardMovieManager getAwardMovieFactory() {
		// TODO Auto-generated method stub
		return new OscarAwardMovieManager();
	}
}
