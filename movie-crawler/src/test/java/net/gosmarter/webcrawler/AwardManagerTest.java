package net.gosmarter.webcrawler;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.AwardManager;

public class AwardManagerTest {

	AwardManager awardManager = new AwardManager();
	
	@Test
	public void testGetList() throws IOException {
		List<Award> awards = awardManager.getList();

		assertTrue(0 < awards.size());
	}
}
