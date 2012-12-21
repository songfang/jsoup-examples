package net.gosmarter.spring;

import net.gosmarter.webcrawler.AwardMovieManager;
import net.gosmarter.webcrawler.AwardYearManager;

public class AwardCrawler {
	
	public AwardYearManager getAwardYearManager() {
		return awardYearManager;
	}
	public void setAwardYearManager(AwardYearManager awardYearManager) {
		this.awardYearManager = awardYearManager;
	}
	public AwardMovieManager getAwardMovieManager() {
		return awardMovieManager;
	}
	public void setAwardMovieManager(AwardMovieManager awardMovieManager) {
		this.awardMovieManager = awardMovieManager;
	}
	private AwardYearManager awardYearManager;
	private AwardMovieManager awardMovieManager;
	
	public void crawl() {
		// TODO Auto-generated method stub	
	}
}
