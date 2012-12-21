package net.gosmarter.webcrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CannesGoldenPalmsAwardMovieManager implements AwardMovieManager {
	private static Logger logger = Logger.getLogger(CannesGoldenPalmsAwardMovieManager.class);

	public List<AwardMovie> getList(AwardYear awardYear) throws IOException {
		List<AwardMovie> awards = new ArrayList<AwardMovie>();
		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org" + awardYear.getWikipediaSource());
		Document doc = Jsoup.parse(url, 3000);

		Element awardSpan = doc.select("span[id=Awards").first();
		Element uiElm = awardSpan.parent().nextElementSibling();
		Iterator<Element> awardLiList = uiElm.select("li").iterator();
		while (awardLiList.hasNext()) {
			Element liElm = awardLiList.next();
			Elements elms = liElm.select("a");
			if (elms.size() > 0) {
				Element aElm = elms.get(0);
				Element movieElm = elms.get(1);
				logger.debug("aElm=" + aElm.text());
				AwardMovie movie = new AwardMovie(movieElm.attr("href"), movieElm.text(), awardYear.getYear());
				if (aElm.text().equals("Palme d'Or")) {
					movie.setBestMovie(true);
					logger.debug(movie);
					awards.add(movie);
				} else if (aElm.text().equals("Best Actor")) {
					movie.setBestLeadHero(true);
					logger.debug(movie);
					awards.add(movie);
				} else if (aElm.text().equals("Best Actress")) {
					movie.setBestLeadHeroine(true);
					logger.debug(movie);
					awards.add(movie);
				} else if (aElm.text().equals("Best Director")) {
					movie.setBestDirector(true);
					logger.debug(movie);
					awards.add(movie);
				}
			}
		}
		return awards;
	}
}
