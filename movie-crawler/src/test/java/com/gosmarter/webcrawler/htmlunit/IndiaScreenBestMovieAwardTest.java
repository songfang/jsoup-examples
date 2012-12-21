package com.gosmarter.webcrawler.htmlunit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class IndiaScreenBestMovieAwardTest {

	private static Logger logger = Logger.getLogger(IndiaScreenBestMovieAwardTest.class);

	@Test
	public void testBestMovieList() throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		final WebClient webClient = new WebClient();
		final HtmlPage startPage = webClient.getPage("http://en.wikipedia.org/wiki/Screen_Award_for_Best_Film");

		String source = "/html/body/div[4]/div[3]/div[4]/table[2]/tbody/tr[:2*:]/td[2]/i/a/@href";
		String[] sourceArr = source.split(":");

		String title = "/html/body/div[4]/div[3]/div[4]/table[2]/tbody/tr[:2*:]/td[2]/i/a/@title";
		String[] titleArr = title.split(":");

		int startIndex = getStartIndex(titleArr);

		int index = 0;
		for (int i = 0; i < 100; i++) {
			index++;
			if (index < startIndex) {
				continue;
			}
			String titleData = titleArr[0] + index + titleArr[2];
			String sourceData = sourceArr[0] + index + sourceArr[2];
			List<DomNode> titleNodes = (List<DomNode>) startPage.getByXPath(titleData);
			if (titleNodes.size() == 0) {
				break;
			}
			for (DomNode titleNode : titleNodes) {
				logger.debug(titleNode.getNodeName() + " ***** " + titleNode.getNodeValue());
			}

			List<DomNode> sourceNodes = (List<DomNode>) startPage.getByXPath(sourceData);
			for (DomNode sourceNode : sourceNodes) {
				logger.debug(sourceNode.getNodeName() + " ***** " + sourceNode.getNodeValue());
			}
		}
	}

	int getStartIndex(String[] titleArr) {
		String startIndexStr = titleArr[1].substring(0, titleArr[1].length() - 1);
		return Integer.parseInt(startIndexStr);
	}
}
