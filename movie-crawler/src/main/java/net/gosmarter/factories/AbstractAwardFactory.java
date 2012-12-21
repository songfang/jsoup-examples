package net.gosmarter.factories;

import net.gosmarter.webcrawler.AwardMovieManager;
import net.gosmarter.webcrawler.AwardYearManager;

public abstract class AbstractAwardFactory {
	public static AbstractAwardFactory getInstance(String award) {
		if (award.equals("Academy Award")) {
			return new OscarAwardFactory();
		} else if (award.equals("Cannes Film Festival")) {
			return new CannesFilmFestivalAwardFactory();
		}
		return null;
	}

	public abstract AwardYearManager getAwardYearFactory();

	public abstract AwardMovieManager getAwardMovieFactory();
}
