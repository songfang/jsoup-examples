package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class CarwaleCrawlTest {
	Logger logger = Logger.getLogger(CarwaleCrawlTest.class);

	@Test
	public void testFordIkon() throws Exception {
		URL url = new URL(
				"http://www.carwale.com/used/search_result.aspx?make=5&model=5.14&city=2&dist=50");
		
		String carDetailUrl = "http://www.carwale.com/used/cardetails.aspx?car=";
		
		Document doc = Jsoup.parse(url, 3000);

		Iterator<Element> productList = doc.select(
				"tr[class=dt_body]").iterator();
		assertNotNull(productList);
		while (productList.hasNext()) {
			Element product = productList.next();
			assertNotNull(product);
			logger.debug(carDetailUrl + product.attr("id"));
			Element productTitle = product.select("a").first();
			assertNotNull(productTitle);
			
			logger.debug(productTitle.text());
			Element productPrice = product.select( "td:eq(2)").first();
			logger.debug(productPrice.text());
			Element productYear = product.select( "td:eq(3)").first();
			logger.debug(productYear.text());
			Element productMilage= product.select( "td:eq(4)").first();
			logger.debug(productMilage.text());
			Element productCity = product.select( "td:eq(3)").first();
			logger.debug(productCity.text());
			Element productDate= product.select( "td:eq(4)").first();
			logger.debug(productDate.text());
		}
	}
}
