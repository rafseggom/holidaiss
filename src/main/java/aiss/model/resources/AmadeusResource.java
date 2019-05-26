package aiss.model.resources;

//import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
import java.util.logging.Logger;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightDate;
import com.amadeus.resources.FlightDestination;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;

//import javax.ws.rs.core.HttpHeaders;

//import org.restlet.data.ChallengeResponse;
//import org.restlet.data.ChallengeScheme;
//import org.restlet.resource.ClientResource;
//import org.restlet.resource.ResourceException;

//import com.google.api.client.http.HttpMethods;
//import com.google.appengine.repackaged.com.google.gson.Gson;

//import aiss.model.amadeus.AirportCitySearch;

public class AmadeusResource {
//	private final static Logger LOGGER = Logger.getLogger(AmadeusResource.class.getName());
	private static final Logger log = Logger.getLogger(AmadeusResource.class.getName());

	private static final String CLIENT_ID = "bEeSzA7bLfnSxffpkGU2K4clfTufMjNx";
	private static final String CLIENT_SECRET = "6EdWGwplqzM8f3CF";

//	private final String access_token;
//	private final String baseURL = "https://test.api.amadeus.com/v1/";

//	public AmadeusResource(String access_token) {
//		this.access_token = access_token;
//	}

	// Crear objeto Amadeus para usar la librería
	Amadeus amadeus = Amadeus.builder(CLIENT_ID, CLIENT_SECRET).setLogger(log).build();

	public Location[] getAirportCity(String query) throws IOException, ResponseException {
		Location[] locations = amadeus.referenceData.locations
				.get(Params.with("keyword", query).and("subType", Locations.ANY));
		if (locations[0].getResponse().getStatusCode() != 200) {
			System.out.println("Wrong status code for Airport & City Search 1st endpoint: "
					+ locations[0].getResponse().getStatusCode());
			System.exit(-1);
		}
		return locations;

	}

	public FlightDestination[] getVuelos(String query, Long precio, String fecha) throws ResponseException {

		LocalDate fechaLD = LocalDate.parse(fecha);
		String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(fechaLD);
		FlightDestination[] flightDestinations = amadeus.shopping.flightDestinations
				.get(Params.with("origin", query).and("departureDate", date).and("maxPrice", precio));

		if (flightDestinations[0].getResponse().getStatusCode() != 200) {
			System.out.println("Wrong status code for Flight Search 1st endpoint: "
					+ flightDestinations[0].getResponse().getStatusCode());
			System.exit(-1);
		}
		return flightDestinations;
	}

	public FlightDate[] getCheapestFlight(String origen, String destino, Long precio, String fecha)
			throws ResponseException {
		if (fecha == null && precio == null) {
			FlightDate[] flightDates = amadeus.shopping.flightDates
					.get(Params.with("origin", origen).and("destination", destino));

			if (flightDates[0].getResponse().getStatusCode() != 200) {
				System.out.println("Wrong status code for Flight Search 1st endpoint: "
						+ flightDates[0].getResponse().getStatusCode());
				System.exit(-1);
			}
			return flightDates;
		} else if (precio == null) {
			LocalDate fechaLD = LocalDate.parse(fecha);
			String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(fechaLD);
			FlightDate[] flightDates = amadeus.shopping.flightDates
					.get(Params.with("origin", origen).and("destination", destino).and("departureDate", date));

			if (flightDates[0].getResponse().getStatusCode() != 200) {
				System.out.println("Wrong status code for Flight Search 1st endpoint: "
						+ flightDates[0].getResponse().getStatusCode());
				System.exit(-1);
			}
			return flightDates;
		} else if (fecha == null) {
			FlightDate[] flightDates = amadeus.shopping.flightDates
					.get(Params.with("origin", origen).and("destination", destino).and("maxPrice", precio));

			if (flightDates[0].getResponse().getStatusCode() != 200) {
				System.out.println("Wrong status code for Flight Search 1st endpoint: "
						+ flightDates[0].getResponse().getStatusCode());
				System.exit(-1);
			}
			return flightDates;
		} else {
			LocalDate fechaLD = LocalDate.parse(fecha);
			String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(fechaLD);
			FlightDate[] flightDates = amadeus.shopping.flightDates.get(Params.with("origin", origen)
					.and("destination", destino).and("departureDate", date).and("maxPrice", precio));

			if (flightDates[0].getResponse().getStatusCode() != 200) {
				System.out.println("Wrong status code for Flight Search 1st endpoint: "
						+ flightDates[0].getResponse().getStatusCode());
				System.exit(-1);
			}
			return flightDates;
		}
	}

	public HotelOffer[] getHotel(String query) throws ResponseException {
		HotelOffer[] hotelOffer = amadeus.shopping.hotelOffers.get(Params.with("cityCode", query));
		if (hotelOffer[0].getResponse().getStatusCode() != 200) {
			System.out.println(
					"Wrong status code for Hotel Search 1st endpoint: " + hotelOffer[0].getResponse().getStatusCode());
			System.exit(-1);
		}
		return hotelOffer;
	}

}
