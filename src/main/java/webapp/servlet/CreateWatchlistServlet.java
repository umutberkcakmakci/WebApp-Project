package webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webapp.DAO.CreateWatchlistDAO;
import webapp.resource.Movie;
import webapp.resource.WatchList;
import java.util.List;
import webapp.DAO.DeleteWatchlistDAO;

//import webapp.model.Movie; // Replace with your package path for Movie
//import webapp.model.WatchList; // Replace with your package path for WatchList

/**
 * Creates a watchlist to the database.
 * 
 * @author Meltem Yanoglu
 */
@WebServlet("/create-watchlist") 
public final class CreateWatchlistServlet extends AbstractDatabaseServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Request parameters 
        String watchlistName = req.getParameter("watchlist_name");
        List<Integer> movieIds = getMovieIdsFromRequest(req); // Assuming movie IDs are sent as strings

        // Model
        WatchList watchlist = null;
        String message = null;

        try {
            // Create a list of Movie objects (modify based on your logic
            
            new DeleteWatchlistDAO(getConnection(), watchlistName).access();

            // Create a new watchlist object
            watchlist = new WatchList(0, watchlistName, movieIds);

            // Creates a new DAO object and stores the watchlist
            new CreateWatchlistDAO(getConnection(), watchlist).access();

            message = "Watchlist successfully submitted.";

            LOGGER.info("Watchlist '%s' submitted.", watchlistName);

        } catch (SQLException ex) {
            message = "Failed to submit watchlist: an error occurred while accessing the database.";

            LOGGER.error("Failed to submit watchlist: an error occurred while accessing the database.", ex);
        } catch (NumberFormatException ex) {
            message = "Failed to submit watchlist: invalid movie ID format.";

            LOGGER.error("Failed to submit watchlist: invalid movie ID format.", ex);
        } finally {
        }
        
        HttpSession session = req.getSession();
        session.setAttribute("message", message);
        req.getRequestDispatcher("/jsp/watchlist-created.jsp").forward(req, res);
    }

    private List<Integer> getMovieIdsFromRequest(HttpServletRequest req) {
        // Implement logic to extract movie IDs from the request
        // You can iterate through request parameters or use a specific format for movie IDs
        List<Integer> movieIds = new ArrayList<>();
        String moviesString = req.getParameter("ids");
        while (moviesString.indexOf(",") != -1){
            String newMovie = moviesString.substring(0, moviesString.indexOf(","));
            movieIds.add(Integer.valueOf(newMovie));
            moviesString = moviesString.substring(moviesString.indexOf(",") + 2);
        }
        movieIds.add(Integer.valueOf(moviesString));
        
        // ... (logic to extract movie IDs from the request)
        return movieIds;
    }

}

