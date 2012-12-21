package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class FlipkartCrawlTest {

	Logger logger = Logger.getLogger(FlipkartCrawlTest.class);

	@Test
	public void testSonyLed() throws Exception {

		URL url = new URL(
				"http://www.flipkart.com/tvs-audio-video-players/tv-video/pr?sid=ckf,see&q=sony%20led");
		Document doc = Jsoup.parse(url, 3000);

		Iterator<Element> productList = doc.select(
				"div[class=product browse-product]").iterator();

		assertNotNull(productList);
		while (productList.hasNext()) {
			Element product = productList.next();
			assertNotNull(product);
			Element productLink = product.select("a").first();
			assertNotNull(productLink);

			String href = productLink.attr("abs:href");
			logger.debug("product link: " + href);
			Element productImage = product.select("img").first();
			String productImageSrc = productImage.attr("src");
			logger.debug("product Image Source: " + productImageSrc);
			String productImageTitle = productImage.attr("title");
			assertNotNull(productImage);
			logger.debug("product Title: " + productImageTitle);

			Element priceDiv = product.select("span[class=price final-price")
					.first();
			assertNotNull(priceDiv);
			logger.debug("product Price: " + priceDiv.text());

			Element rating = product.select(
					"div[class=ratings fk-font-small bmargin3]").first();

			Element ratingNext = rating.select(
						"div[class=fk-stars-small]").first();
			if(ratingNext != null){
				assertNotNull(ratingNext);
				String stars = ratingNext.attr("title");
				logger.debug("product Rating Stars: " + stars);
				logger.debug("product Rating Stars: " + rating.text());
			}
		}
	}
}
