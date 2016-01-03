package net.gosmarter.webcrawler;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NetflixCrawlTest {

	@Test
	public void testMovieList() throws IOException {
		Document doc = Jsoup
				.connect("http://www.netflix.com/title/20704518")
				.cookie("NetflixId",
						"ct%3DBQAOAAEBED3jPtwW85gQ1VHPTbddyVyBsNP1J9jDUph850088bwl7NHi6vHfg5pxvvhQFww8jiv_iprwGjK8ctmrEIWHZDsaxC3UHwh00YKjj-DmDT5xsgNQwjpaRdiG_eLkN_r1KlVnPeohtnOBzwY0uB5v7vs-Qigm1K6C4WUjk7EcPGR79Za-EDau1T3L-LgImpZMnjI5pmVxd5t9wgqTWdl_yJ7hWCWJBYI6gMBJ43YJQsOPsy3bNvMJLEoH65FLgwT1gJd55PO0hrW0YT0JmmvEv7L5yXa1Q1yf5lqxpnH8hEB2Bq1ZkIndiXvqZHT0siyVJUU7IqFHs5icYxLsqsf1fjh8xLfy-HBLB9RzACdwfIAGgTpEqGPy29X-PmZr0jP0CsfRGQW1qP4vN8BVb-jRh-IHDCjgaoGASfwZ8yrQLCPU9uTcifJjtFu1DbvZkuKkLAfJu4yS--WnWx5wMoUcs8fK07YF4sXlNPR5E66L6WbmfgL_rjffJYgKgb0joug0YK_i5wxNij_kZAnp10yhE8VNwDqA6PDssMI5l-jvMp-ZDbJWhqOLVnxEpNjmECruEbKYdLFVCUe516Wf44U_NdjWjQ..%26bt%3Dusr%26ch%3DAQEAEAABABQvKzq8QsbLGAL9qmdsbGM3wi0HJt6wlbU.%26v%3D2%26mac%3DAQEAEAABABS4sfOMQFjNRB4gz7arHn0g0QWjpU2d7tA.")
				.cookie("profilesNewSession", "0").cookie("profilesNewUser", "0").get();
		assertNotNull(doc);

		RestTemplate tamplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		String nCookie = "NetflixId=ct%3DBQAOAAEBED3jPtwW85gQ1VHPTbddyVyBsNP1J9jDUph850088bwl7NHi6vHfg5pxvvhQFww8jiv_iprwGjK8ctmrEIWHZDsaxC3UHwh00YKjj-DmDT5xsgNQwjpaRdiG_eLkN_r1KlVnPeohtnOBzwY0uB5v7vs-Qigm1K6C4WUjk7EcPGR79Za-EDau1T3L-LgImpZMnjI5pmVxd5t9wgqTWdl_yJ7hWCWJBYI6gMBJ43YJQsOPsy3bNvMJLEoH65FLgwT1gJd55PO0hrW0YT0JmmvEv7L5yXa1Q1yf5lqxpnH8hEB2Bq1ZkIndiXvqZHT0siyVJUU7IqFHs5icYxLsqsf1fjh8xLfy-HBLB9RzACdwfIAGgTpEqGPy29X-PmZr0jP0CsfRGQW1qP4vN8BVb-jRh-IHDCjgaoGASfwZ8yrQLCPU9uTcifJjtFu1DbvZkuKkLAfJu4yS--WnWx5wMoUcs8fK07YF4sXlNPR5E66L6WbmfgL_rjffJYgKgb0joug0YK_i5wxNij_kZAnp10yhE8VNwDqA6PDssMI5l-jvMp-ZDbJWhqOLVnxEpNjmECruEbKYdLFVCUe516Wf44U_NdjWjQ..%26bt%3Dusr%26ch%3DAQEAEAABABQvKzq8QsbLGAL9qmdsbGM3wi0HJt6wlbU.%26v%3D2%26mac%3DAQEAEAABABS4sfOMQFjNRB4gz7arHn0g0QWjpU2d7tA.";
		String profilesNewSession = "profilesNewSession=0";
		String profilesNewUser = "profilesNewUser=0";
		requestHeaders.add("Cookie", nCookie + ";" + profilesNewSession + ";" + profilesNewUser);
		HttpEntity requestEntity = new HttpEntity(null, requestHeaders);

		ResponseEntity rssResponse = tamplate.exchange(
				"http://www.netflix.com/api/shakti/7ffaa772/bob?titleid=20704518&trackid=13462986&authURL=",
				HttpMethod.GET, requestEntity, String.class);

		System.out.println(rssResponse.getBody());
		assertTrue(((String)rssResponse.getBody()).contains("Darr"));
	}

	@Test
	public void testMovieReviews() throws IOException {
		
		RestTemplate tamplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		String nCookie = "NetflixId=ct%3DBQAOAAEBED3jPtwW85gQ1VHPTbddyVyBsNP1J9jDUph850088bwl7NHi6vHfg5pxvvhQFww8jiv_iprwGjK8ctmrEIWHZDsaxC3UHwh00YKjj-DmDT5xsgNQwjpaRdiG_eLkN_r1KlVnPeohtnOBzwY0uB5v7vs-Qigm1K6C4WUjk7EcPGR79Za-EDau1T3L-LgImpZMnjI5pmVxd5t9wgqTWdl_yJ7hWCWJBYI6gMBJ43YJQsOPsy3bNvMJLEoH65FLgwT1gJd55PO0hrW0YT0JmmvEv7L5yXa1Q1yf5lqxpnH8hEB2Bq1ZkIndiXvqZHT0siyVJUU7IqFHs5icYxLsqsf1fjh8xLfy-HBLB9RzACdwfIAGgTpEqGPy29X-PmZr0jP0CsfRGQW1qP4vN8BVb-jRh-IHDCjgaoGASfwZ8yrQLCPU9uTcifJjtFu1DbvZkuKkLAfJu4yS--WnWx5wMoUcs8fK07YF4sXlNPR5E66L6WbmfgL_rjffJYgKgb0joug0YK_i5wxNij_kZAnp10yhE8VNwDqA6PDssMI5l-jvMp-ZDbJWhqOLVnxEpNjmECruEbKYdLFVCUe516Wf44U_NdjWjQ..%26bt%3Dusr%26ch%3DAQEAEAABABQvKzq8QsbLGAL9qmdsbGM3wi0HJt6wlbU.%26v%3D2%26mac%3DAQEAEAABABS4sfOMQFjNRB4gz7arHn0g0QWjpU2d7tA.";
		String profilesNewSession = "profilesNewSession=0";
		String profilesNewUser = "profilesNewUser=0";
		requestHeaders.add("Cookie", nCookie + ";" + profilesNewSession + ";" + profilesNewUser);
		
		String body = "{\"paths\":[[\"videos\",20704518,\"recentReviews\",{\"from\":0,\"to\":19},[\"id\",\"rating\",\"reviewText\",\"helpfulCount\",\"notHelpfulCount\"]],[\"videos\",20704518,[\"reviewVotes\",\"reviewFlags\"]]],\"authURL\":\"1451784453664.Z9Fj5zcDE0AaZDKEGGQYDx6ya8o=\"}";
		HttpEntity requestEntity = new HttpEntity(body, requestHeaders);

		ResponseEntity rssResponse = tamplate.exchange(
				"http://www.netflix.com/api/shakti/7ffaa772/pathEvaluator?withSize=true&materialize=true&model=harris&fallbackEsn=SLW32-",
				HttpMethod.POST, requestEntity, String.class);

		assertTrue(((String)rssResponse.getBody()).contains("Darr"));
	}

	@Test
	public void testSimilarMovies() throws IOException {
		RestTemplate tamplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		String nCookie = "NetflixId=ct%3DBQAOAAEBED3jPtwW85gQ1VHPTbddyVyBsNP1J9jDUph850088bwl7NHi6vHfg5pxvvhQFww8jiv_iprwGjK8ctmrEIWHZDsaxC3UHwh00YKjj-DmDT5xsgNQwjpaRdiG_eLkN_r1KlVnPeohtnOBzwY0uB5v7vs-Qigm1K6C4WUjk7EcPGR79Za-EDau1T3L-LgImpZMnjI5pmVxd5t9wgqTWdl_yJ7hWCWJBYI6gMBJ43YJQsOPsy3bNvMJLEoH65FLgwT1gJd55PO0hrW0YT0JmmvEv7L5yXa1Q1yf5lqxpnH8hEB2Bq1ZkIndiXvqZHT0siyVJUU7IqFHs5icYxLsqsf1fjh8xLfy-HBLB9RzACdwfIAGgTpEqGPy29X-PmZr0jP0CsfRGQW1qP4vN8BVb-jRh-IHDCjgaoGASfwZ8yrQLCPU9uTcifJjtFu1DbvZkuKkLAfJu4yS--WnWx5wMoUcs8fK07YF4sXlNPR5E66L6WbmfgL_rjffJYgKgb0joug0YK_i5wxNij_kZAnp10yhE8VNwDqA6PDssMI5l-jvMp-ZDbJWhqOLVnxEpNjmECruEbKYdLFVCUe516Wf44U_NdjWjQ..%26bt%3Dusr%26ch%3DAQEAEAABABQvKzq8QsbLGAL9qmdsbGM3wi0HJt6wlbU.%26v%3D2%26mac%3DAQEAEAABABS4sfOMQFjNRB4gz7arHn0g0QWjpU2d7tA.";
		String profilesNewSession = "profilesNewSession=0";
		String profilesNewUser = "profilesNewUser=0";
		requestHeaders.add("Cookie", nCookie + ";" + profilesNewSession + ";" + profilesNewUser);
		
		String body = "{\"paths\":[[\"videos\",20704518,\"similars\",{\"from\":0,\"to\":25},[\"synopsis\",\"title\",\"summary\",\"queue\",\"trackId\",\"maturity\",\"runtime\",\"seasonCount\",\"releaseYear\",\"userRating\",\"availability\"]],[\"videos\",20704518,\"similars\",{\"from\":0,\"to\":25},\"boxarts\",[\"_260x146\",\"_342x192\"],\"jpg\"],[\"videos\",20704518,\"similars\",{\"from\":0,\"to\":25},\"seasonList\",\"current\",\"showMemberType\"],[\"videos\",20704518,\"similars\",{\"from\":0,\"to\":25},\"current\",\"summary\"],[\"videos\",20704518,\"similars\",[\"summary\",\"trackId\"]],[\"videos\",20704518,[\"commonsense\",\"subtitles\",\"audio\",\"availabilityEndDateNear\",\"copyright\"]],[\"videos\",20704518,\"festivals\",{\"from\":0,\"to\":10},{\"from\":0,\"to\":10},[\"type\",\"winner\"]],[\"videos\",20704518,\"festivals\",{\"from\":0,\"to\":10},{\"from\":0,\"to\":10},\"person\",[\"name\",\"id\"]],[\"videos\",20704518,\"festivals\",{\"from\":0,\"to\":10},[\"length\",\"name\",\"year\"]],[\"videos\",20704518,\"festivals\",\"length\"],[\"videos\",20704518,[\"creators\",\"directors\"],{\"from\":0,\"to\":49},[\"id\",\"name\"]],[\"videos\",20704518,[\"creators\",\"directors\"],\"summary\"],[\"videos\",20704518,\"cast\",{\"from\":6,\"to\":49},[\"id\",\"name\"]],[\"videos\",20704518,\"genres\",3,[\"id\",\"name\"]],[\"videos\",20704518,\"trailers\",{\"from\":0,\"to\":25},[\"title\",\"summary\",\"trackId\",\"availability\"]],[\"videos\",20704518,\"trailers\",{\"from\":0,\"to\":25},\"interestingMoment\",\"_260x146\",\"jpg\"],[\"videos\",20704518,\"trailers\",{\"from\":0,\"to\":25},\"current\",\"summary\"],[\"videos\",20704518,\"seasonList\",{\"from\":0,\"to\":20},\"summary\"],[\"videos\",20704518,\"seasonList\",\"summary\"]],\"authURL\":\"1451785782463.yX68g3d2z5XERruy1SdPEvIBbhs=\"}";
		HttpEntity requestEntity = new HttpEntity(body, requestHeaders);

		ResponseEntity rssResponse = tamplate.exchange(
				"http://www.netflix.com/api/shakti/7ffaa772/pathEvaluator?withSize=true&materialize=true&model=harris&fallbackEsn=SLW32-",
				HttpMethod.POST, requestEntity, String.class);

		System.out.println(rssResponse.getBody());
		assertTrue(((String)rssResponse.getBody()).contains("His daughter"));
	}
}
