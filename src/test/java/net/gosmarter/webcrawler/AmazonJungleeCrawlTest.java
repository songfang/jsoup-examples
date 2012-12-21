package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class AmazonJungleeCrawlTest {

	Logger logger = Logger.getLogger(AmazonJungleeCrawlTest.class);

	@Test
	public void testLaptop() throws Exception {
		
		//This has keyword and pagination
		URL url = new URL(
				"http://www.junglee.com/mn/search/junglee/ref=sr_pg_1?url=search-alias%3Dcomputers&field-keywords=laptop");
		Document doc = Jsoup.parse(url, 3000);

		for (int i = 0; i < Integer.MAX_VALUE; i++) {

			Element productResult = doc.select("div[id=result_" + i + "]")
					.first();

			if (productResult == null) {
				break;
			}
			assertNotNull(productResult);

			Element image = productResult.select("img[class=productImage]")
					.first();
			logger.debug(image.attr("src"));

			Element title = productResult.select("a[class=title]").first();
			logger.debug(title.attr("href"));
			logger.debug(title.text());

			Element price = productResult.select("span[class=price]").first();
			logger.debug(price.text());

			Element sellerCount = productResult.select("div[class=offerCount]")
					.first();
			logger.debug(sellerCount.text());

			Element ratingCountDiv = productResult.select(
					"div[class=asinReviewsSummary]").first();
			//The rating may or may not be there
			if (ratingCountDiv != null) {
				Element ratingCount = ratingCountDiv.select("img").first();
				logger.debug(ratingCount.attr("alt"));
			}
			Element reviewsCount = productResult.select(
					"div[class=reviewsCount]").first();
			//The review count may or may not be there
			if (reviewsCount != null) {
				logger.debug(reviewsCount.text());
			}
		}
	}
}
