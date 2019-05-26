package aiss.model.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.HttpHeaders;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.http.HttpMethods;
import com.google.appengine.repackaged.com.google.gson.Gson;

import aiss.model.mapbox.PlaceSearch;

public class MapboxResource {

//	private static final String OMDB_API_KEY = "a00dffb4"; // TODO: Change this API KEY for your personal Key
	private static final String MAPBOX_ACCESS_TOKEN = "pk.eyJ1IjoiaG9saWRhaXNzIiwiYSI6ImNqdXh3NzhiazBiOHEzem5yYnd6dDE0cHEifQ.ZqBUau5q5_-mkYwCoFn6aQ";
	private static final Logger log = Logger.getLogger(MapboxResource.class.getName());

	public PlaceSearch getPlace(String query) throws JsonProcessingException, IOException {
		String search_text = URLEncoder.encode(query, "UTF-8");
		// String tipo = URLEncoder.encode(type, "UTF-8");

		String uri = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + search_text + ".json?access_token="
				+ MAPBOX_ACCESS_TOKEN;
		log.log(Level.FINE, "Mapbox URI: " + uri);

		// http://www.omdbapi.com/?t=Dumbo&y=2019&plot=full
		// http://www.omdbapi.com/?apikey=[yourkey]&

		// ClientResource cr = new ClientResource(uri);
		URL url = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestProperty(HttpHeaders.ACCEPT, "application/vnd.geo+json; charset=utf-8");
		con.setRequestMethod(HttpMethods.GET);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		Gson g = new Gson();
		PlaceSearch placeSearch = g.fromJson(content.toString(), PlaceSearch.class);

		/*
		 * SOLUCION 2 Representation representation = cr.get();
		 * 
		 * //Definimos ObjectMapper para extraer el cuerpo de la respuesta: ObjectMapper
		 * mapper = new ObjectMapper(); //Extraemos el cuerpo de la respuesta: JsonNode
		 * jsonNode = mapper.readTree(representation.getStream()); //Y lo convertimos en
		 * cadena de texto String JSONContent = jsonNode.toString();
		 * System.out.println(JSONContent);
		 * 
		 * //Finalmente, usamos otro ObjectMapper para convertir el texto en objecto
		 * Java ObjectMapper mapper2 = new ObjectMapper(); PlaceSearch placeSearch =
		 * mapper2.readValue(JSONContent, PlaceSearch.class); //PlaceSearch placeSearch
		 * = cr.get(PlaceSearch.class);
		 */

		return placeSearch;
	}
}
