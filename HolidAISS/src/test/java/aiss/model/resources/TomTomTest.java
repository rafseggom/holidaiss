package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.tomtom.FuzzySearch;
import aiss.model.tomtom.POISearch;

public class TomTomTest {

	@Test
	public void getFuzzySearch() throws IOException {
		String query = "Sevilla";
		TomTomResource tt = new TomTomResource();
		FuzzySearch tomtomResults = tt.getFuzzySearch(query);

		assertNotNull("The search returned null", tomtomResults);
		assertFalse("The number of places for " + query + " is zero", tomtomResults.getResults().size() == 0);

		System.out.println("The place you look for is " + tomtomResults.getResults());
		System.out.println("You got " + tomtomResults.getResults().size() + " fuzzy search results.");
	}

	public void getPOISearch() throws IOException {
		String query = "Sevilla";
		TomTomResource tt = new TomTomResource();
		POISearch tomtomResults = tt.getPOISearch(query);

		assertNotNull("The search returned null", tomtomResults);
		assertFalse("The number of places for " + query + " is zero",
				tomtomResults.getSummary().getTotalResults() == 0);

		System.out.println("The POI you look for is " + tomtomResults.getResults());
		System.out.println("You got " + tomtomResults.getResults().size() + " POI results.");
	}

	public static void main(String[] args) {

	}

}
