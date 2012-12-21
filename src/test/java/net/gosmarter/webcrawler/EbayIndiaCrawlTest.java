package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class EbayIndiaCrawlTest {

	Logger logger = Logger.getLogger(EbayIndiaCrawlTest.class);

	@Test
	public void testIphone5() throws Exception {
		URL url = new URL(
				"http://www.ebay.in/sch/i.html?_nkw=iphone+5");
		Document doc = Jsoup.parse(url, 3000);

		Iterator<Element> productList = doc.select(
				"table[class=li wb]").iterator();
		assertNotNull(productList);
		while (productList.hasNext()) {
			Element product = productList.next();
			assertNotNull(product);
			Element productLink = product.select("a[class=vip g-b]").first();
			
			String src = productLink.attr("href");
			logger.debug(src);
			String title = productLink.attr("title");
			logger.debug(title);
			Element price = product.select( "td:eq(4)").first();
			logger.debug(price.text());
		}
	}

}
