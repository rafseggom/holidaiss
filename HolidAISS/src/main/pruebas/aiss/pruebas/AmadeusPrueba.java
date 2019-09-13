package aiss.pruebas;

import org.junit.Test;

import com.amadeus.Amadeus;
import com.amadeus.Params;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;

public class AmadeusPrueba {
	@Test
	public static void main(String[] args) throws ResponseException {
		Amadeus amadeus = Amadeus.builder("bEeSzA7bLfnSxffpkGU2K4clfTufMjNx", "6EdWGwplqzM8f3CF").build();

		Location[] locations = amadeus.referenceData.locations
				.get(Params.with("keyword", "Italy").and("subType", Locations.ANY));

		System.out.println(locations);
	}
}
