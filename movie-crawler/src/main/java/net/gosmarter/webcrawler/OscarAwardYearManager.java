package net.gosmarter.webcrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.gosmarter.spring.AwardCrawlInvokar;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OscarAwardYearManager implements AwardYearManager {
	public static String awardName = "Academy Award";

	private static Logger logger = Logger.getLogger(OscarAwardYearManager.class);
	private static String wikipediaSource = "/wiki/Academy_Awards";

	public List<AwardYear> getList() throws IOException {
		ArrayList<AwardYear> awardYears = new ArrayList<AwardYear>();
		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org" + wikipediaSource);
		Document doc = Jsoup.parse(url, 3000);

		Element table = doc.select("table[class=sortable wikitable").first();

		Iterator<Element> trList = table.select("tr").iterator();
		while (trList.hasNext()) {
			Element trElm = trList.next();

			Element tdElm = trElm.select("td").first();
			if (tdElm != null) {

				Element aElm = tdElm.select("a").first();
				String year = getYear(aElm.text());

				AwardYear awardYear = new AwardYear(awardName, aElm.attr("href"), year);
				logger.debug("Year Link" + awardYear.getWikipediaSource() + " year=" + year);
				awardYears.add(awardYear);
			}
		}
		return awardYears;
	}

	private static String getYear(String text) {

		String[] split = text.split(" ");
		String yearData = split[0];
		String year = yearData.substring(0, 2);
		if (yearData.length() == 3) {
			year = yearData.substring(0, 1);
		}
		return year;
	}
}
