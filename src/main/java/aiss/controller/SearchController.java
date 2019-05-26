package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightDate;
import com.amadeus.resources.FlightDestination;
//import com.amadeus.resources.HotelOffer;

import aiss.model.resources.AmadeusResource;
import aiss.model.resources.TomTomResource;
import aiss.model.tomtom.FuzzySearch;

/**
 * Servlet implementation class SearchController
 */

public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query = request.getParameter("searchQuery");
		String destino = request.getParameter("searchDestino");
		String price = request.getParameter("searchPrice");
		String date = request.getParameter("searchDate");
		RequestDispatcher rd = null;

		log.log(Level.FINE, "Searching in Amadeus and Mapbox: " + query);

		// Search for place in TomTom
		TomTomResource Tomtom = new TomTomResource();
		FuzzySearch TomTomResults = Tomtom.getFuzzySearch(query);

		if (TomTomResults != null) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("results", TomTomResults.getResults());
		} else {
			log.log(Level.SEVERE, "Tomtom object: " + TomTomResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		// Search for flights on Amadeus
		log.log(Level.FINE, "Searching for airports or cities that contain " + query);

		AmadeusResource Amadeus = new AmadeusResource();
		Location[] AmadeusPlace = null;
		FlightDestination[] AmadeusResults = null;
		FlightDate[] AmadeusCheap = null;
//		HotelOffer[] AmadeusHotel = null;
		try {
			Long precio = Long.valueOf(price);
			AmadeusPlace = Amadeus.getAirportCity(query);
			AmadeusResults = Amadeus.getVuelos(query, precio, date);
			AmadeusCheap = Amadeus.getCheapestFlight(query, destino, precio, date);
//			AmadeusHotel = Amadeus.getHotel(destino);

			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("locations", AmadeusPlace);
			request.setAttribute("flights", AmadeusResults);
			request.setAttribute("cheapFlights", AmadeusCheap);
//			request.setAttribute("hotels", AmadeusHotel);
		} catch (ResponseException e) {
			log.log(Level.SEVERE, "Amadeus object: " + AmadeusResults);
			log.log(Level.SEVERE, "Amadeus object 2: " + AmadeusCheap);
			rd = request.getRequestDispatcher("/error.jsp");
			e.printStackTrace();
		}

		rd.forward(request, response);
		request.getSession().setAttribute("locations", AmadeusPlace);
		request.getSession().setAttribute("results", query);
		request.getSession().setAttribute("flights", AmadeusResults);
		request.getSession().setAttribute("cheapFlights", AmadeusCheap);
//		request.getSession().setAttribute("hotels", AmadeusHotel);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
