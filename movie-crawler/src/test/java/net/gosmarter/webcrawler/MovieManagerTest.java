package net.gosmarter.webcrawler;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.gosmarter.webcrawler.jsoup.MovieManager;

public class MovieManagerTest {
	MovieManager movieManager = new MovieManager();
	
	@Test
	public void testMovie() throws IOException{
		Movie movie = movieManager.getMovie("/wiki/Amour_(2012_film)", "Amour");
		assertEquals( movie.getDirector(), "Michael Haneke");
	}
}
