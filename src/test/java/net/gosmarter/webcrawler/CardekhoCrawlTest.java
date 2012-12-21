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

public class CardekhoCrawlTest {

	Logger logger = Logger.getLogger(CardekhoCrawlTest.class);

	@Test
	public void testMarutiAlto() throws Exception {
		URL url = new URL(
				"http://www.cardekho.com/used-maruti cars in bangalore");

		Document doc = Jsoup.parse(url, 50000);
		
		Iterator<Element> productList = doc.select("li[id=SubTableDetails]")
				.iterator();
		assertNotNull(productList);
		assertTrue(productList.hasNext());
		while (productList.hasNext()) {
			Element product = productList.next();
			assertNotNull(product);
			Element productId = product.select("ul").first();
			logger.debug(productId.attr("id"));
			
			Element descLi = productId.select( "li:eq(1)").first();
			String imageSrc = descLi.attr("onclick").split(",")[2];
			logger.debug("Image Source " + imageSrc);
			
			Element descA = descLi.select("a").first();
			logger.debug("Desc " + descA.text());
			
			Element priceLi = productId.select( "li:eq(2)").first();
			logger.debug("Price " + priceLi.text());
			Element yearLi = productId.select( "li:eq(3)").first();
			logger.debug("Year " + yearLi.text());
			Element kmsLi = productId.select( "li:eq(4)").first();
			logger.debug("Kms " + kmsLi.text());
			Element cityLi = productId.select( "li:eq(5)").first();
			logger.debug("City " + cityLi.text());	        
			Element sellerTypeLi = productId.select( "li:eq(6)").first();
			logger.debug("Seller Type " + sellerTypeLi.text());	        
			Element detailsLi = productId.select( "li:eq(8)").first();
			Element detailsA = detailsLi.select( "a").first();
			logger.debug("Details " + detailsA.attr("href"));	        
		}
	}
}
