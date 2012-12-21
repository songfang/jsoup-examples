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

public class AwardManager {
	private static Logger logger = Logger.getLogger(AwardManager.class);

	public List<Award> getList() throws IOException {
		ArrayList<Award> awards = new ArrayList<Award>();

		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org/wiki/Movie_award");
		Document doc = Jsoup.parse(url, 3000);

		Iterator<Element> awardList = doc.select("a").iterator();

		while (awardList.hasNext()) {
			Element awardElm = awardList.next();
			logger.debug(awardElm.parent().tagName());
			if (awardElm.parent().tagName().equals("li")) {
				String source = awardElm.attr("href");
				if (source.startsWith("/wiki")) {
					Award award = new Award(awardElm.text(), source);
					awards.add(award);
				}
			}
		}

		return awards;
	}
}
