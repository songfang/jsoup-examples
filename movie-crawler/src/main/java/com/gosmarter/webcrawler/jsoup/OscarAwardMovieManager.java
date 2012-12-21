package com.gosmarter.webcrawler.jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.gosmarter.webcrawler.AwardMovie;
import net.gosmarter.webcrawler.AwardMovieManager;
import net.gosmarter.webcrawler.AwardYear;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OscarAwardMovieManager implements AwardMovieManager {
	private static Logger logger = Logger
			.getLogger(OscarAwardMovieManager.class);

	public List<AwardMovie> getList(AwardYear awardYear) throws IOException {
		List<AwardMovie> awards = new ArrayList<AwardMovie>();
		// This has keyword and pagination
		URL url = new URL("http://en.wikipedia.org"
				+ awardYear.getWikipediaSource());
		Document doc = Jsoup.parse(url, 3000);

		Element awardTable = doc.select("table[class=wikitable").first();

		awards.addAll(getMovies(awardTable.select("td").get(0),
				awardYear.getYear(), AwardCategory.BestPicture));
		awards.addAll(getMovies(awardTable.select("td").get(1),
				awardYear.getYear(), AwardCategory.BestDirector));
		awards.addAll(getMovies(awardTable.select("td").get(2),
				awardYear.getYear(), AwardCategory.BestActor));
		awards.addAll(getMovies(awardTable.select("td").get(3),
				awardYear.getYear(), AwardCategory.BestActress));
		awards.addAll(getMovies(awardTable.select("td").get(7),
				awardYear.getYear(), AwardCategory.BestActress));

		return awards;
	}

	private List<AwardMovie> getMovies(Element element, String year,
			AwardCategory mode) {

		ArrayList<AwardMovie> list = new ArrayList<AwardMovie>();
		Iterator<Element> liList = element.select("li").iterator();

		int index = 0;
		while (liList.hasNext()) {
			Element aElm = liList.next().select("a").first();
			String source = aElm.attr("href");
			String name = aElm.text();
			AwardMovie awardMovie = new AwardMovie(source, name, year);

			if (index == 0) {
				if (mode == AwardCategory.BestPicture
						|| mode == AwardCategory.BestForeignMovie) {
					awardMovie.setBestMovie(true);
				} else if (mode == AwardCategory.BestDirector) {
					awardMovie.setBestDirector(true);
				} else if (mode == AwardCategory.BestActor) {
					awardMovie.setBestLeadHero(true);
				} else if (mode == AwardCategory.BestActress) {
					awardMovie.setBestLeadHeroine(true);
				}
			} else {
				if (mode == AwardCategory.BestPicture
						|| mode == AwardCategory.BestForeignMovie) {
					awardMovie.setNominatedBestMovie(true);
				} else if (mode == AwardCategory.BestDirector) {
					awardMovie.setNominatedBestDirector(true);
				} else if (mode == AwardCategory.BestActor) {
					awardMovie.setNominatedBestLeadHero(true);
				} else if (mode == AwardCategory.BestActress) {
					awardMovie.setNominatedBestLeadHeroine(true);
				}
			}
			logger.debug("awardMovie " + awardMovie);
			list.add(awardMovie);
			index++;
		}

		return list;
	}
}
