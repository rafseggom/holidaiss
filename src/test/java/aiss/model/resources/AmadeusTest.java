package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightDate;
import com.amadeus.resources.Location;

public class AmadeusTest {
	@Test

	public void getAirPortCityTest() throws IOException, ResponseException {
		String query = "Madrid";
		Amadeus amadeus = Amadeus.builder("bEeSzA7bLfnSxffpkGU2K4clfTufMjNx", "6EdWGwplqzM8f3CF").build();
		Location[] locations = amadeus.referenceData.locations
				.get(Params.with("keyword", query).and("subType", Locations.ANY));

		assertNotNull("The search returned null", locations);
		assertFalse("The number of airports and cities for " + query + " is zero", locations.length == 0);

		System.out.println("The airport or city you look for is " + locations.toString());
	}

//	public void getCheapFlightTest() throws IOException, ResponseException {
//		String origen = "MAD";
//		String destino = "MUC";
//		Amadeus amadeus = Amadeus.builder("bEeSzA7bLfnSxffpkGU2K4clfTufMjNx", "6EdWGwplqzM8f3CF").build();
//		Long precio = 300l;
//		LocalDate fecha = LocalDate.of(2019, 6, 6);
//		if (fecha == null && precio == null) {
//			FlightDate[] flightDates = amadeus.shopping.flightDates
//					.get(Params.with("origin", origen).and("destination", destino));
//
//			if (flightDates[0].getResponse().getStatusCode() != 200) {
//				System.out.println("Wrong status code for Flight Search 1st endpoint: "
//						+ flightDates[0].getResponse().getStatusCode());
//				System.exit(-1);
//			}
//			assertNotNull("The search returned null", flightDates);
//			assertFalse("The number of flights for " + origen + " is zero", flightDates.length == 0);
//
//			System.out.println("The flight you look for is " + flightDates.toString());
//		} else if (precio == null) {
//			LocalDate date = LocalDate.of(2019, 6, 6);
//			FlightDate[] flightDates = amadeus.shopping.flightDates
//					.get(Params.with("origin", origen).and("destination", destino).and("departureDate", date));
//
//			if (flightDates[0].getResponse().getStatusCode() != 200) {
//				System.out.println("Wrong status code for Flight Search 1st endpoint: "
//						+ flightDates[0].getResponse().getStatusCode());
//				System.exit(-1);
//			}
//			assertNotNull("The search returned null", flightDates);
//			assertFalse("The number of flights for " + origen + " is zero", flightDates.length == 0);
//
//			System.out.println("The flight you look for is " + flightDates.toString());
//		} else if (fecha == null) {
//			FlightDate[] flightDates = amadeus.shopping.flightDates
//					.get(Params.with("origin", origen).and("destination", destino).and("maxPrice", precio));
//
//			if (flightDates[0].getResponse().getStatusCode() != 200) {
//				System.out.println("Wrong status code for Flight Search 1st endpoint: "
//						+ flightDates[0].getResponse().getStatusCode());
//				System.exit(-1);
//			}
//			assertNotNull("The search returned null", flightDates);
//			assertFalse("The number of flights for " + origen + " is zero", flightDates.length == 0);
//
//			System.out.println("The flight you look for is " + flightDates.toString());
//		} else {
//			LocalDate date = LocalDate.of(2019, 6, 6);
//			FlightDate[] flightDates = amadeus.shopping.flightDates.get(Params.with("origin", origen)
//					.and("destination", destino).and("departureDate", date).and("maxPrice", precio));
//
//			if (flightDates[0].getResponse().getStatusCode() != 200) {
//				System.out.println("Wrong status code for Flight Search 1st endpoint: "
//						+ flightDates[0].getResponse().getStatusCode());
//				System.exit(-1);
//			}
//			assertNotNull("The search returned null", flightDates);
//			assertFalse("The number of flights for " + origen + " is zero", flightDates.length == 0);
//
//			System.out.println("The flight you look for is " + flightDates.toString());
//		}
//	}

//	public void getFlightTest() throws IOException, ResponseException {
//		Amadeus amadeus = Amadeus.builder("bEeSzA7bLfnSxffpkGU2K4clfTufMjNx", "6EdWGwplqzM8f3CF").build();
//		Long precio = 300l;
//		LocalDate fecha = LocalDate.of(2019, 6, 6);
//		String query = "MAD";
//		FlightDestination[] flightDestinations = amadeus.shopping.flightDestinations.get(Params.with("origin", query)
//				.and("departureDate", fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).and("maxPrice", precio));
//
//		assertNotNull("The search returned null", flightDestinations);
//		assertFalse("The number of flights for " + query + " is zero", flightDestinations.length == 0);
//
//		System.out.println("The flight you look for is " + flightDestinations.toString());
//	}

//	public void getHotelTest() throws IOException, ResponseException {
//		Amadeus amadeus = Amadeus.builder("bEeSzA7bLfnSxffpkGU2K4clfTufMjNx", "6EdWGwplqzM8f3CF").build();
//		String query = "MAD";
//		HotelOffer[] hotelOffer = amadeus.shopping.hotelOffers.get(Params.with("cityCode", query));
//
//		assertNotNull("The search returned null", hotelOffer);
//		assertFalse("The number of flights for " + query + " is zero", hotelOffer.length == 0);
//
//		System.out.println("The hotel you look for is " + hotelOffer.toString());
//	}

	public static void main(String[] args) {

	}
}
