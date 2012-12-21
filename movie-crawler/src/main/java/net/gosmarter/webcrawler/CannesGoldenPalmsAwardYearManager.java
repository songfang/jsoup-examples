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

public class CannesGoldenPalmsAwardYearManager implements AwardYearManager {
	public static String awardName = "Cannes Golden Palms Award";

	private static Logger logger = Logger.getLogger(OscarAwardYearManager.class);
	private static String wikipediaSource = "/wiki/Palme_d'Or";

	public List<AwardYear> getList() throws IOException {
		ArrayList<AwardYear> awardYears = new ArrayList<AwardYear>();
		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org" + wikipediaSource);
		Document doc = Jsoup.parse(url, 3000);
		Element table = doc.select("table[class=wikitable sortable").first();

		Iterator<Element> trList = table.select("tr").iterator();
		while (trList.hasNext()) {
			Element trElm = trList.next();

			Element tdElm = trElm.select("td").first();
			if (tdElm != null) {

				Element aElm = tdElm.select("a").first();
				if (aElm != null) {
					String year = getYear(aElm.text());
					if (AwardCrawlInvokar.isNumeric(year)) {

						AwardYear awardYear = new AwardYear(awardName, aElm.attr("href"), year);
						logger.debug("Year Link" + awardYear.getWikipediaSource() + " year=" + year);
						awardYears.add(awardYear);
					}
				}
			}
		}
		return awardYears;
	}

	private static String getYear(String text) {
		// TODO Auto-generated method stub
		return text;
	}
}
