package aiss.controller;


import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Playlists;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyPlaylistsGetController extends HttpServlet {

    private static final long serialVersionUID = -6818025976353856770L;
    private static final Logger log = Logger.getLogger(SpotifyPlaylistNewController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String accessToken = (String) req.getSession().getAttribute("Spotify-token");

        if (accessToken != null && !"".equals(accessToken)) {

            SpotifyResource spResource = new SpotifyResource(accessToken);
            Playlists playlists = spResource.getPlaylists();

            if (playlists != null && playlists.getItems() != null && playlists.getItems().size() > 0 && playlists.getItems().get(0) != null) {
                req.setAttribute("playlists", playlists);
                req.getRequestDispatcher("/spotifyPlaylistsListing.jsp").forward(req, resp);
            } else {
                log.warning("no playlists available for this user");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

}
