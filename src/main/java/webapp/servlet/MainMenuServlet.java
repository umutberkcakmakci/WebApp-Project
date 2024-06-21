package webapp.servlet;

import webapp.DAO.AwardDAO;
import webapp.DAO.MovieDAO;
import webapp.DAO.TopRatedMovieDAO;
import webapp.resource.Movie;


import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import webapp.resource.Award;

@WebServlet(name = "MainMenuServlet", urlPatterns = "/main-menu")
public class MainMenuServlet extends AbstractDatabaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection con = getConnection()) {
            // Retrieve movies
            MovieDAO movieDAO = new MovieDAO(con);
            List<Movie> movies = movieDAO.access().getOutputParam();




            // Retrieve top-rated movies
            /*TopRatedMovieDAO topRatedMovieDAO = new TopRatedMovieDAO(con);
            List<Movie> topRatedMovies = topRatedMovieDAO.access().getOutputParam();*/

            
            HttpSession session = request.getSession();
            // Set attributes for JSP rendering
            session.setAttribute("movies", movies);
            //request.setAttribute("topRatedMovies", topRatedMovies);

            // Forward to main menu JSP
            request.getRequestDispatcher("jsp/homepage.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }
    }
}
