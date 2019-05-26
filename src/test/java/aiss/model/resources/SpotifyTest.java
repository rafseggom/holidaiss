package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.*;

import aiss.model.spotify.SearchTracks;

public class SpotifyTest {
	// https://developer.spotify.com/console/get-search-item/
	@Test
	public void getTracks() throws UnsupportedEncodingException {
//		String query = "Muse";
//		SpotifyResource st = new SpotifyResource(
//				"BQA3WEb0n00FCHytI2TojFmq6ZYv8yZ_-sVebavfC-HH5Fv9RGZflq3UOLkSq4GNi1D6TnU-HkYV2OS82gizod9IgEw8yZUEWwZB6zkzt8AXc96wT_yYfmHJuaZTsUpZVbh3yjlGx0UqmNtH6tGzoDhzZu86NhxmJA");
//		SearchTracks spotifyResults = st.getSearchTrack(query);
//
//		assertNotNull("The search returned null", spotifyResults);
//		assertFalse("The number of tracks for " + query + " is zero",
//				spotifyResults.getTracks().getItems().size() == 0);
//
//		System.out.println("The track you look for is " + spotifyResults.getTracks().getItems().get(0).getName()
//				+ " by " + spotifyResults.getTracks().getItems().get(0).getArtists().get(0).getName());
	}

	public static void main(String[] args) {

	}

}
