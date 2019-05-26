package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.junit.Test;

import aiss.model.mapbox.PlaceSearch;

public class MapboxTest {

	@Test
	public void getPlaceTest() throws JsonProcessingException, IOException {
		String place = "Georgia";
		MapboxResource sp = new MapboxResource();
		PlaceSearch mapboxResults = sp.getPlace(place);

		assertNotNull("The search returned null", mapboxResults);
		assertFalse("The number of places for " + place + " is zero", mapboxResults.getFeatures().size() == 0);

		System.out.println("The place you look for is " + mapboxResults.getFeatures());
	}

	public static void main(String[] args) {

	}

}
