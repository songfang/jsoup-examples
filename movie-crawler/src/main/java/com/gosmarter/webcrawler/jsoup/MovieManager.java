package com.gosmarter.webcrawler.jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import net.gosmarter.webcrawler.Movie;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MovieManager {
	private static Logger logger = Logger.getLogger(MovieManager.class);

	public Movie getMovie(String wikiSource, String name) throws IOException {
		Movie movie = new Movie();
		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org" + wikiSource);
		Document doc = Jsoup.parse(url, 3000);

		Element infoTable = doc.select("table[class=infobox vevent").first();
		Element trElm = infoTable.select("tr").get(1);
		Element imgElm = trElm.select("img").first();

		movie.setName(name);
		movie.setImageUrl(imgElm.attr("src"));
		movie.setDirector(getData(infoTable, 2));
		movie.setProducer(getData(infoTable, 3));
		movie.setScreenplay(getData(infoTable, 4));
		movie.setStarring(getData(infoTable, 5));
		movie.setCinematography(getData(infoTable, 6));
		movie.setEditing(getData(infoTable, 7));
		movie.setCountry(getData(infoTable, 12));
		movie.setLanguage(getData(infoTable, 13));
		movie.setBudget(getData(infoTable, 14));

		return movie;
	}

	private String getData(Element infoTable, int index) {
		Element trElm = infoTable.select("tr").get(index);
		Element tdElm = trElm.select("td").first();
		Element aElm = tdElm.select("a").first();
		String str = "";
		String str1 = "";
		if (aElm != null) {
			str = aElm.text();
		}
		if (tdElm != null) {
			str = tdElm.text();
		}
		logger.debug(str + str1);
		return str + str1;
	}
}
