package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class BikedekhoCrawlTest {

	Logger logger = Logger.getLogger(BikedekhoCrawlTest.class);

	@Test
	public void testBajajAvenger() throws Exception {
		URL url = new URL(
				"http://www.bikedekho.com/used-bikes/hyderabad/bajaj-avenger/used-bajaj-avenger-bikes.htm?page=1");

		Document doc = Jsoup.parse(url, 50000);
		
		Iterator<Element> productList = doc.select("li[class=Hand CommonBlock H50 H50]").iterator();
		assertNotNull(productList);
		assertTrue(productList.hasNext());
		while (productList.hasNext()) {
			Element product = productList.next();
			assertNotNull(product);

			Element descLi = product.select( "li:eq(0)").first();
			Element descA = descLi.select( "a").first();
			
			logger.debug("Details Link " + descA.attr("href"));
			logger.debug("Desc " + descA.text());
			
			Element priceLi = product.select( "li:eq(1)").first();
			logger.debug("Price " + priceLi.text());

			Element yrLi = product.select( "li:eq(2)").first();
			logger.debug("Yr " + yrLi.text());
			
			Element kmsLi = product.select( "li:eq(3)").first();
			logger.debug("Kms " + kmsLi.text());

			Element colorLi = product.select( "li:eq(4)").first();
			logger.debug("Color " + colorLi.text());

			Element cityLi = product.select( "li:eq(5)").first();
			logger.debug("City " + cityLi.text());
		}
	}
}
