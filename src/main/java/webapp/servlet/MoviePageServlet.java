package webapp.servlet;

import jakarta.servlet.ServletException;
import webapp.DAO.CreateMovieDAO;
import webapp.DAO.GetMovieByIdDAO;

import webapp.resource.Movie;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import webapp.DAO.GetPersonsByMovieIdDAO;
import webapp.DAO.GetRatesByMovieIdDAO;
import webapp.resource.Person;
import webapp.resource.Rates;

@WebServlet(name = "MoviePageServlet", urlPatterns = "/movie")
public class MoviePageServlet extends AbstractDatabaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // request parameter
        int movieId = Integer.parseInt(req.getParameter("id"));

        // model
        Movie movie = null;
        
        List<Person> persons = null;
        
        List<Rates> rates = null;

        try {
            // retrieve movie information by id
            movie = new GetMovieByIdDAO(getConnection(), movieId).access().getOutputParam();
            
            persons = new GetPersonsByMovieIdDAO(getConnection(), movieId).access().getOutputParam();
            
            rates = new GetRatesByMovieIdDAO(getConnection(), movieId).access().getOutputParam();
            HttpSession session = req.getSession();
            session.setAttribute("movie", movie);
            session.setAttribute("persons", persons);
            session.setAttribute("rates", rates);
            
            

            req.getRequestDispatcher("jsp/get-movie.jsp").forward(req, res); // Forward to JSP page
        } catch (NumberFormatException | SQLException ex) {
            // Handle exceptions
            req.setAttribute("error", ex.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}

