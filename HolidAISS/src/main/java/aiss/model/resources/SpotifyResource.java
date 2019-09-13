package aiss.model.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonProcessingException;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotify.NewPlaylist;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.Search;
import aiss.model.spotify.SearchTracks;
import aiss.model.spotify.UserProfile;

public class SpotifyResource {

	private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

	private final String access_token;
	private final String baseURL = "https://api.spotify.com/v1";

	public SpotifyResource(String access_token) {
		this.access_token = access_token;
	}

	public SearchTracks getSearchTrack(String song) {
		String searchUrl = baseURL + "/search?" + "q=" + song + "&type=track";
		ClientResource cr = new ClientResource(searchUrl);

		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);

		SearchTracks tracks = null;
		try {
			tracks = cr.get(SearchTracks.class);
			return tracks;

		} catch (ResourceException re) {
			log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
			log.warning(searchUrl);
			return null;
		}
	}

	public Playlists getPlaylists() {
		String playlistsGetURL = baseURL + "/me/playlists";
		ClientResource cr = new ClientResource(playlistsGetURL);

		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);

		Playlists playlists = null;
		try {
			playlists = cr.get(Playlists.class);
			return playlists;

		} catch (ResourceException re) {
			log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
			log.warning(playlistsGetURL);
			return null;
		}
	}

	public Search getSearch(String query) throws JsonProcessingException, IOException {
		String search_text = URLEncoder.encode(query, "UTF-8");
		String playlistsGetURL = baseURL + "/search?q=Top " + search_text + "&type=playlist&limit=1";
		ClientResource cr = new ClientResource(playlistsGetURL);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);

		Search search = null;
		try {
			search = cr.get(Search.class);
			return search;

		} catch (ResourceException re) {
			log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
			log.warning(playlistsGetURL);
			return null;
		}
	}
	
	  public boolean createPlaylist(String name, String description) {
	        // We need the Spotify UserID in order to make requests to this POST URL
	        String userId = this.getUserId();
	        if (userId != null && !name.trim().isEmpty()) {
	        	String playlistPostURL = baseURL + "/users/" + userId + "/playlists";
	            // ToDo: create post URL (you'll need the userId)
	        	ClientResource cr = new ClientResource(playlistPostURL);
	        	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        	chr.setRawValue(access_token);
	        	cr.setChallengeResponse(chr);
	            // ToDo: create properly the ClientResource and the ChallengeResponse
	        	NewPlaylist p = new NewPlaylist();
	        	p.setName(name);
	        	p.setDescription(description);
	            // ToDo: create the NewPlaylist object and set the properties
	        	log.info("Creating new playlist with name " + name + " description: " + description + " for user: " + userId);
	            // ToDo: pprint useful log information

	            try {
	                // ToDo: call the ClientResource post method with the proper values
	            	cr.post(p, MediaType.APPLICATION_ALL_JSON);
	                return true;

	            } catch (ResourceException re) {
	                // ToDo: print useful log information before returning
	            	log.warning("Error when creating a Spotify playlist: " + cr.getResponse().getStatus());
	            	log.warning(playlistPostURL);
	                return false;
	            }
	        } else {
	            log.warning("Error when getting userID from Spotify");
	            return false;
	        }
	    }


	protected String getUserId() {
		String userProfileURL = baseURL + "/me";
		ClientResource cr = new ClientResource(userProfileURL);

		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);

		log.info("Retrieving user profile");

		try {
			return cr.get(UserProfile.class).getId();

		} catch (ResourceException re) {
			log.warning("Error when retrieving the user profile: " + cr.getResponse().getStatus());
			log.warning(userProfileURL);
			return null;
		}
	}
}
