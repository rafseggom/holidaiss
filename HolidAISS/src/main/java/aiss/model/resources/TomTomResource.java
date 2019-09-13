package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.tomtom.FuzzySearch;
import aiss.model.tomtom.POISearch;

public class TomTomResource {

	private static final Logger log = Logger.getLogger(TomTomResource.class.getName());
	private static final String TOMTOM_ACCESS_TOKEN = "D5IYmsgLaSB7BkLe9jgyhDA923FgG0mS";
	private final String baseURL = "https://api.tomtom.com/search/2/";

	public FuzzySearch getFuzzySearch(String query) throws UnsupportedEncodingException {
		String keyword = URLEncoder.encode(query, "UTF-8");
		String uri = baseURL + "search" + "/" + keyword + ".json?key=" + TOMTOM_ACCESS_TOKEN;
		System.out.println(uri);
		log.log(Level.FINE, "TomTom URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		FuzzySearch fuzzySearch = cr.get(FuzzySearch.class);
		return fuzzySearch;

	}

	public POISearch getPOISearch(String query) throws UnsupportedEncodingException {
		String keyword = URLEncoder.encode(query, "UTF-8");
		String uri = baseURL + "poiSearch" + "/" + keyword + ".json?key=" + TOMTOM_ACCESS_TOKEN;
		System.out.println(uri);
		log.log(Level.FINE, "TomTom URI: " + uri);

		ClientResource cr = new ClientResource(uri);
		POISearch poiSearch = cr.get(POISearch.class);
		return poiSearch;

	}
}
