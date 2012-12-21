package net.gosmarter.spring;

import java.util.List;

public class AwardCrawlInvokar {
	
	private List<AwardCrawler> awardCrawlers;

	public List<AwardCrawler> getAwardCrawlers() {
		return awardCrawlers;
	}

	public void setAwardCrawlers(List<AwardCrawler> awardCrawlers) {
		this.awardCrawlers = awardCrawlers;
	}
	
	public void run(){
		for(AwardCrawler crawler : awardCrawlers){
			crawler.crawl();
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}
}
