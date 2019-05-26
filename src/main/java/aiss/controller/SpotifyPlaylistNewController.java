package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Search;

public class SpotifyPlaylistNewController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -6818025976353856770L;
    private static final Logger log = Logger.getLogger(SpotifyPlaylistNewController.class.getName());
    
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String accessToken = null;
		if (name != null && description != null) {
			accessToken = (String) req.getSession().getAttribute("Spotify-token");

			if (accessToken != null && !"".equals(accessToken)) {
				SpotifyResource spResource = new SpotifyResource(accessToken);
				spResource.createPlaylist(name, description);

			} else { 
				log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp);
			}
		} else {
			 log.warning("no parameters passed");
             req.getRequestDispatcher("/spotifyPlaylistCreate.jsp").forward(req, resp);
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
